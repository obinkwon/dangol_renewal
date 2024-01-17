<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>단골의 here</title>
	<link rel="stylesheet" href="/css/signup.css" />
	<script>
		function signupMember() {
			location.href='/login/signup/membersForm.do';
		}
		
		function signupBoss() {
			location.href='/login/signup/bossForm.do';
		}
	</script>
</head>
<body>
<div class="cotn_principal">
	<div class="cont_centrar">
  		<div class="cont_login">
			<div class="cont_info_log_sign_up">
      			<div class="col_md_login">
					<div class="cont_ba_opcitiy">
        				<h2>일반</h2>  
						<img class="img-fluid" src="/img/signup/free-icon-user.png" width="100" height="100">
						<button class="btn_login" onclick="signupMember()">사용자 가입하기</button>
					</div>
				</div>
				<div class="col_md_sign_up">
					<div class="cont_ba_opcitiy">
						<h2>가맹점주</h2>
						<img class="img-fluid" src="/img/signup/free-icon-boss.png" width="100" height="100">
						<button class="btn_sign_up" onclick="signupBoss()">가맹점 가입하기</button>
					</div>
				</div>
			</div>
    		<div class="cont_back_info">
       			<div class="cont_img_back_grey">
       				<img src="/img/signup/signup-background.jpg" alt="" />
       			</div>
			</div>
			<div class="cont_forms" >
				<div class="cont_img_back_">
					<img src="/img/signup/signup-background.jpg" alt="" />
				</div>
				<div class="cont_form_login">
				</div>
				<div class="cont_form_sign_up">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>