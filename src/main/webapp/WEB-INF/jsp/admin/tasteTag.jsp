<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>맛태그_관리자화면</title>
	<script type="text/javascript">
		//태그 추가
		function addTag(){
			var tagTxt = $('#tasteTagText').val();
			var params = {
				atype : 'taste',
				avalue : tagTxt
			};
		
			if(tagTxt == ''){
				alert('추가할 태그를 입력하세요');
			}else{
				$.ajax({
			        url : "/admin/insertTag.do",
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
		
		//태그 삭제
		function deleteTag(anum){
			var params = {
				anum : anum
			};
			
			if (confirm("정말로 삭제하시겠습니까?")) {
				if(anum == ''){
					alert('삭제할 태그가 없습니다');
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
	</script>
</head>
<body>
<div class="container-fluid">
	<div class="p-5">
		<h3>맛태그 설정</h3>
		<form id="frmList" action="insertTasteTag.do" method="get">
			<div class="row g-3 mt-2">
				<div class="col">
					<input type="text" class="form-control" name="keyword" aria-label="keyword" id="tasteTagText" placeholder="추가할 태그를 입력하세요">
				</div>
				<div class="col">
					<button type="button" class="btn btn-outline-primary" onclick="addTag();">추가하기</button>
				</div>
			</div>
		</form>
		<table class="table table-hover mt-3">
			<thead>
				<tr>
					<th scope="col">테마</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tasteTag" items="${tasteTags}">
					<tr>
						<td><c:out value="${tasteTag.avalue}"/></td>
						<td>
							<button type="button" class="btn-close" aria-label="delete" onclick="deleteTag('<c:out value="${tasteTag.anum}"/>');" ></button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>