<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>추천태그_관리자화면</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<style type="text/css">
		div.nav{
			margin-top: 50px;
			float: left;
			width: 13%;
			margin-left: 50px;
		}
		div.section{
			margin-top : 50px;
			float : right;
			width : 60%;
			margin-right : 200px;
		}
		li.nav_active {
			background-color: #66ccff;
		}
		a.navTitle {
			font-size: 15px;
			font-weight: bold;
			color: #000000;
			text-align: center;
		}
		a.nav {
			text-align: center;
			font-size: 14px;
			color: #000000;
		}
		.inputText {
		    height: 40px;
		    line-height: 40px;
		    color: #7b6e66;
		    padding: 0 7px;
		    border: 1px solid #7b6e66;
		    background-color: transparent;
		    vertical-align: middle;
		    float: left;
		}
		.w300 {
		    width: 300px;
		}
		.btn-view {
		    width: 200px;
		    font-size: 1.4rem;
		    background-color: #fff;
		    color: #000000;
		    height: 4rem;
		    line-height: 3.9rem;
		    font-weight: 600;
		    letter-spacing: 0.5px;
		    transition-duration: .5s;
		    border: 0.1rem solid #66ccff;
		}
	</style>
	
	<script type="text/javascript">
		function applyTag(type){ // 태그 적용
			if(type == 1){ //main1
				location.href="selectMain.do?atype=main1&avalue="+$('#select_main1').val();
			}else{ //main2
				location.href="selectMain.do?atype=main2&avalue="+$('#select_main2').val();
			}
		}
	</script>
	
	<decorator:head ></decorator:head>
</head>
<body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	  	<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#"><strong>Admin Page</strong></a>
  		<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
	  	<div class="navbar-nav">
	    	<div class="nav-item text-nowrap">
	      		<a class="nav-link px-3" href="#">Sign out</a>
	    	</div>
	  	</div>
	</header>
	<div class="container">
		<decorator:body ></decorator:body>
	</div>
</body>
</html>