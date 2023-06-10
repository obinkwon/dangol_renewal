<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<div class="container text-center">
		<p class="h3 mb-3 fw-normal">회원가입</p>
		<div class="row mt-4">
			<div class="col">
				<div class="card shadow-sm">
					<a href="signUpMembersForm.do"><img class="img-fluid" src="/img/myPage.png" width="100" height="100"></a>
					<b>일반</b>
				</div>
			</div>
			<div class="col">
				<div class="card shadow-sm">
					<a href="signUpBossForm.do"><img class="img-fluid" src="/img/ceo.png" width="100" height="100"></a>
					<b>가맹점주</b>
				</div>
			</div>	
		</div>
	</div>
</body>
</html>