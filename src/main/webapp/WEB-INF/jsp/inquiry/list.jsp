<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>자주묻는질문</title>
	<script type="text/javascript">
	$(document).ready(function(){
		$('.delBtn').click(function() { 
			var inum= $(this).closest("tr").find("td:eq(0)").text();
			var result = confirm('정말로 삭제하시겠습니까?');
			if(result) { 
				
				location.replace('removeInquiry.do?inum='+inum);
				} else {
					
				} 
		});
		
		$('.inquirytitle').click(function(){
			var inum =$(this).closest("tr").find("td:eq(0)").text();
			 location.href="inquiryView.do?inum="+inum;
		});
		
		$('button#searchInquiry').click(function(){
			 location.href="searchInquiry.do?keyword="+$('input#searchInquiryText').val();
		})
		
		$('#inquiryBtn').on('click', function(){
			location.href = '/inquiry/inquiryForm.do';
		});
		
	});
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="p-5">
			<ul class="nav nav-pills">
				<li class="nav-item"><a href="#" class="nav-link">고객센터</a></li>
				<li class="nav-item"><a href="/inquiry/faq.do" class="nav-link">자주 묻는 질문</a></li>
				<li class="nav-item"><a href="/inquiry/list.do" class="nav-link active" >1:1문의</a></li>
			</ul>
			<div class="inquiryText">
				<h2 class="page-header">1:1문의</h2>
				ㆍ평균24시간 이내 답변됩니다.<br>
				ㆍ고객센터로 문의 가능합니다.<br>
				ㆍ전화번호, 주소, 이메일, 계좌번호 등의 개인정보는 타인에 의해 도용될 위험이 있으니,문의 시 입력하지 않도록 주의해 주시기 바랍니다.
			</div>
	
			<div class="col-lg-6">
				<input type="button" id="inquiryBtn" value="1:1문의하기">
			    <div class="input-group">
			      <input type="text" id="searchInquiryText" class="form-control"  placeholder="Search for...">
			      <span class="input-group-btn">
			        <button id="searchInquiry" class="btn btn-default" type="button">Search</button>
			      </span>
			    </div>
		    </div>
  
			<table class="table" >
				<tr>
					<th width="10%" >문의번호</th>
					<th width="20%">문의유형</th>
					<th width="25%">문의제목</th>
					<th width="22%">문의날짜</th>
					<th width="13%">답변상태</th>
					<th width="10%">삭제</th>
				</tr>
				<c:forEach var="inquiry" items="${inquirylist}">
				<tr>
					<td class="inquirylist">${inquiry.inum}</td>
					<td class="inquirylist">
						<c:choose>
							<c:when test="${inquiry.itype=='service'}">서비스 이용</c:when>
							<c:otherwise>사이트 이용</c:otherwise>
						</c:choose>
					</td>
					<td class="inquirytitle">${inquiry.ititle}</td>
					<td class="inquirylist">${inquiry.idate}</td>
					<td class="inquirylist">
						<c:choose>
							<c:when test="${inquiry.istate=='yes'}">답변완료</c:when>
							<c:otherwise>답변대기중</c:otherwise>
						</c:choose>
					<td class="inquirylist">
						<button class="delBtn"><img class="cancelImg" src="jsp/cancel.png" ></button>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>