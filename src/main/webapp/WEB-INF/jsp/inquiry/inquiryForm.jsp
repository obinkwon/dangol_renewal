<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>자주묻는질문</title>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#delBtn').on('click', function() { 
			if(confirm('정말 취소하시겠습니까?')) { 
				location.href = '/inquiry/list.do';
			}
		});
		
		$('#insertBtn').on('click', function() {
			if(($('#ititle').val() == '')){
				alert("제목을 입력해주세요.");
			}else if($('#icontent').val() == ''){
				alert("내용을 입력해주세요.");
			}else{
				var params = {
					ititle: $('#ititle').val(),
					itype: $('#itype').val(),
					icontent: $('#icontent').val(),
				};
			    
				$.ajax({
			        url : "/inquiry/insertInquiry.do",
			        type : "post",
			        dataType : "json",
			        data : params,
			        success : function(response) {
			            console.log(response);
			            if( response.code != "3001"){
			            	alert(response.message);
			            }else{
			            	alert('1:1문의가 등록되었습니다.');
			            	location.href = '/inquiry/list.do'
			            }
			        }, error : function(jqXHR, status, e) {
			            console.error(status + " : " + e);
			        }
			    });	 
			}
		});
	});
	</script>
	
</head>
<body>
	<div class="container-fluid">
		<ul class="nav nav-pills">
			<li class="nav-item"><a href="#" class="nav-link">고객센터</a></li>
			<li class="nav-item"><a href="/inquiry/faq.do" class="nav-link">자주 묻는 질문</a></li>
			<li class="nav-item"><a href="/inquiry/list.do" class="nav-link active" >1:1문의</a></li>
		</ul>
		<div class="form-signin w-50 m-auto">
			<form id="insertForm" action="" method="post">
				<h1 class="h3 mb-3 fw-normal">1:1문의</h1>
				
				<div class="form-floating mt-2">
					<input type="text" class="form-control" id="ititle" name="ititle">
			      	<label for="ititle"><span style="color:red">* </span>제목</label>
				</div>
				<div class="form-floating mt-2">
					<select class="form-select" aria-label="문의구분" name="itype" id="itype">
						<option value="service">서비스 이용</option>
						<option value="site">사이트 이용</option>
					</select>
				</div>
				<div class="form-floating mt-2">
					<textarea class="form-control h-25" id="icontent" rows="5" name="icontent"></textarea>
					<label for="icontent" class="form-label"><span style="color:red">* </span>문의내용</label>
				</div>
				<div class="float-end mt-2">
					<button type="button" class="btn btn-secondary" id="delBtn">취소</button>
					<button type="button" class="btn btn-primary" id="insertBtn">작성완료</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>