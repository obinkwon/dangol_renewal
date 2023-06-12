<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>로그인</title>
	<script type="text/javascript">
	 	//로그인
		function login(){
	 		let id = $('#floatingInput').val();
	 		let pwd = $('#floatingPassword').val();
	 		let loginUser = $('input[name="loginUser"]:checked').val();
	 		
	 		let params = {
	 			id : id,
	 			pwd : pwd,
	 			loginUser : loginUser
	 		};
	 		
			$.ajax({
		        url : "/login/loginAct.do",
		        type : "post",
		        dataType : "json",
		        data : params,
		        success : function(response) {
		            console.log(response);
		            if( response.code != "3001"){
		            	alert(response.message);
		            }else{
		            	location.href = response.path;
		            }
		        }, error : function(jqXHR, status, e) {
		            console.error(status + " : " + e);
		        }
		    });
		}
		
		function find(type){
			location.href='findIdPwForm.do?type=' + type;
		}
	</script>
	<link href="/css/sign-in.css" rel="stylesheet">
</head>
<body>
	<div class="container text-center">
		<div class="form-signin w-100 m-auto">
			<form action="login.do" id="frmLogin">
				<img class="mb-4" src="/img/favicon.png" alt="" width="72" height="57">
				<h1 class="h3 mb-3 fw-normal">로그인</h1>
				
				<input type="radio" class="btn-check" name="loginUser" value="user" id="loginUser-u" autocomplete="off" checked>
				<label class="btn btn-outline-info" for="loginUser-u">사용자</label>
				
				<input type="radio" class="btn-check" name="loginUser" value="boss" id="loginUser-b" autocomplete="off">
				<label class="btn btn-outline-secondary" for="loginUser-b">사장님</label>
				
				<div class="mt-2">
					<div class="form-floating">
						<input type="text" class="form-control" name="id" id="floatingInput" placeholder="아이디">
				      	<label for="floatingInput">아이디</label>
				    </div>
				    <div class="form-floating">
						<input type="password" class="form-control" name="pwd" id="floatingPassword" placeholder="비밀번호">
						<label for="floatingPassword">비밀번호</label>
					</div>
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="button" onclick="login()">로그인</button>
				<button type="button" class="btn btn-link" onclick="find('id')">아이디 찾기</button>
				<button type="button" class="btn btn-link" onclick="find('pwd')">비밀번호 찾기</button>
			</form>
		</div>
	</div>
</body>
</html>