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
	<link href="/css/headers.css" rel="stylesheet">
	<link href="/css/sidebars.css" rel="stylesheet">
	<link href="/css/dashboard.css" rel="stylesheet">
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
	  	<div class="navbar-nav">
	    	<div class="nav-item text-nowrap">
	      		<a class="nav-link px-3" href="/logout.do">Sign out</a>
	    	</div>
	  	</div>
	</header>
	<div class="container-fluid">
		<div class="row">
		    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
		        	<ul class="nav flex-column">
		          		<li class="nav-item">
		            		<a class="nav-link active" aria-current="page" href="#">
		              			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home" aria-hidden="true"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
		              			Dashboard
		            		</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link" href="#">
		              			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file" aria-hidden="true"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
		              			Orders
		            		</a>
		          		</li>
		        	</ul>
		      	</div>
		    </nav>

		    <div class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<decorator:body ></decorator:body>
		    </div>
  		</div>
	</div>
</body>
</html>