<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title>1:1문의_관리자화면</title>
	<script>
		//글 검색하기
		function searchInquiry(){
			var state = $('#selState').val();
			var type = $('#selType').val();
			var keyword = $('#selKeyword').val();
			var url = '/admin/inquirys.do?';
					
			if(state == 'all'){
				url = url + "type="+type+"&keyword="+keyword;
			}else{
				url = url + "istate="+state+"&type="+type+"&keyword="+keyword;
			}
			location.href = url;
		}
			
		// 전체 / 답변완료 / 미답변 클릭
		function selInquiry(type){
			if(type == 'all'){
				location.href="/admin/inquirys.do";
			}else{
				location.href="/admin/inquirys.do?istate="+type;
			}
		}
	</script>
</head>
<body>
<div class="container-fluid">
	<div class="p-5">
		<ul class="nav nav-pills">
			<c:forEach var="item" items="${cntList}" varStatus="status">
		  		<li class="nav-item">
		    		<a href="#" class="nav-link <c:if test="${item.itype eq state}">active</c:if>" aria-current="page" onclick="selInquiry('${item.itype}');">${item.ititle}(${item.cnt})</a>
		  		</li>
			</c:forEach>
		</ul>
		<!-- 글 검색하기 -->
		<form id="frmList" action="" method="get">
		<div class="row g-3 mt-2">
			<div class="col">
				<input type="text"  class="form-control" id="selKeyword" placeholder="검색내용을 입력하세요" value="<c:out value="${searchVO.keyword}"/>">
				<input type="hidden" id="selState" name="state" value="<c:out value="${state}"/>">
			</div>
			<div class="col">
				<select class="form-select" id="selType">
					<option value="title" <c:if test="${searchVO.type eq 'title'}">selected</c:if>>제목으로 찾기</option>
					<option value="content" <c:if test="${searchVO.type eq 'content'}">selected</c:if>>내용으로 찾기</option>
					<option value="mid" <c:if test="${searchVO.type eq 'mid'}">selected</c:if>>ID로 찾기</option>
				</select>
			</div>
			<div class="col">
				<button type="button" class="btn btn-outline-primary" onclick="searchInquiry();">검색</button>
			</div>
		</div>
		</form>
		<table class="table table-hover mt-3">
			<colgroup>
				<col width="10%">
				<col width="20%">
				<col width="*">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">구분</th>
					<th scope="col">제목</th>
					<th scope="col">날짜</th>
					<th scope="col">답변여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="inquiry" items="${iList}" varStatus="status">
				<tr>
					<td><c:out value="${status.index}"/></td>
					<td>
						<c:if test="${inquiry.itype == 'service'}">서비스</c:if>
						<c:if test="${inquiry.itype == 'site'}">사이트</c:if>
					</td>
					<td><a href="selectInquiryDetail.do?inum=${inquiry.inum}">${inquiry.ititle}</a></td>
					<td><fmt:formatDate value="${inquiry.idate}" pattern="yyyy.MM.dd"/></td>
					<td><c:out value="${inquiry.istate == 'Y' ? '답변완료' : '미답변'}" /></td>
				</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
</div>
</body>
</html>