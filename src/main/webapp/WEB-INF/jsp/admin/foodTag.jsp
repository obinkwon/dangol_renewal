<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>업종태그_관리자화면</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$("input[type='file']").each(function(){
				var $target = $(this);
				
				$target.on('change',function(){
					if($(this).val() != ''){
						var ext = $(this).val().split('.').pop().toLowerCase(); //확장자
						if($.inArray(ext, ['gif', 'png', 'jpg']) == -1) {
							$(this).val('');
							alert('이미지 파일이 아닙니다! (gif, png, jpg 만 업로드 가능)');
						} else {
							if(window.FileReader){
								filename = this.files[0].name;
							}
							
							var reader = new FileReader();
							reader.onload = function(e){
								$("#img").attr("src",e.target.result);
							}
							reader.readAsDataURL(this.files[0]);
							$('#img').show();
						}
					}
				});
			});
		});
		
		function addFoodTag(){ //태그 추가
			if($('#foodTagText').val() == '' || $('#afile').val() == ''){
				alert('추가할 태그명과 이미지 파일을 입력해주세요');
			}else{
			    $('#frmList').submit();
			}
		}
		
		//태그 삭제
		function deleteTag(anum){
			var params = {
				anum : anum
			};
			
			if (confirm("정말로 삭제하시겠습니까?")) {
				if(anum == ''){
					alert('추가할 태그를 입력하세요');
				}else{
					$.ajax({
				        url : "/admin/deleteTag.do",
				        type : "post",
				        dataType : "json",
				        data : params,
				        success : function(response) {
				            console.log(response);
				            if( response.code != "3001"){
				            	alert(response.message);
				            }else{
				            	location.reload();
				            }
				        }, error : function(jqXHR, status, e) {
				            console.error(status + " : " + e);
				        }
				    });	 
				}
			}
		}
		
		//이미지 업로드
		function imgUpload(){
			$('#afile').trigger('click');
		}
	</script>
</head>

<body>
<div class="container-fluid">
	<div class="p-5">
		<h3>업종태그 설정</h3>
		<form id="frmList" action="insertTagFile.do" enctype="multipart/form-data" method="post">
			<div class="row g-3">
				<div class="col">
					<input type="hidden" name="atype" value="food">
					<input type="text" class="form-control" name="avalue" placeholder="추가할 태그를 입력하세요" aria-label="avalue" id="foodTagText">
				</div>
				<div class="col">
					<div class="row g-3">
						<div class="col">
							<img id="img" src="" class="img-thumbnail" alt="썸네일이미지" style="display:none;height: 100px">
						</div>
					</div>
				</div>
				<div class="col">
					<button type="button" class="btn btn-secondary" onclick="imgUpload();">이미지 업로드</button>
					<input type="file" name="afile" id="afile" style="display:none;">
				</div>
				<div class="col">
					<button type="button" class="btn btn-outline-primary" onclick="addFoodTag();">추가하기</button>
				</div>
			</div>
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">이미지</th>
					<th scope="col">테마</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="foodTag" items="${foodTags}">
			<tr>
				<td><img src="downloadAimage.do?anum=${foodTag.anum}" alt="사진 파일을 준비중입니다." width="100px" height="100px"></td>
				<td>${foodTag.avalue}</td>
				<td>
					<input type="button" onclick="deleteTag('${foodTag.anum}');" class="btn_del_FoodTag" value="x">
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>