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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />
	<link href="/css/headers.css" rel="stylesheet">
	<link href="/css/sidebars.css" rel="stylesheet">
	<link href="/css/dashboard.css" rel="stylesheet">
	
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
		            		<a class="nav-link <c:if test="${atype eq 'main'}">active</c:if>" href="/admin/recommandTag.do">
		              			추천태그
		            		</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link <c:if test="${atype eq 'theme'}">active</c:if>" href="/admin/themeTag.do">
		              			테마별 태그
		            		</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link <c:if test="${atype eq 'food'}">active</c:if>" href="/admin/foodTag.do">
								업종별 태그
		            		</a>
		          		</li>
		          		<li class="nav-item">
		            		<a class="nav-link <c:if test="${atype eq 'taste'}">active</c:if>" href="/admin/tasteTag.do">
								맛별 태그
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