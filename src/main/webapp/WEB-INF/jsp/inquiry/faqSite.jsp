<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>자주묻는질문</title>
	<script type="text/javascript">
		$(document).ready(function(){
	
			$('#faqSelect').change(function(){
				location.href="faq.do?type="+this.value;
			});
			
			for(var i =1; i<4;i++){
				$('#panel'+i).hide();
			/* 	$('#'+i).click(function(){
					$('#panel'+i).slideDown("fast");	
				}); */
			}
	 		$('#1').click(function(){
				$('#panel1').slideToggle();	
			})
			$('#2').click(function(){
				$('#panel2').slideToggle();	
			})
			$('#3').click(function(){
				$('#panel3').slideToggle();	
			})
				
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="nav">
			<ul class="nav nav-pills nav-stacked">
				<li class="navTitle"><a class="navTitle">고객센터</a></li>
				<li class="active"><a class="nav" href="faq.do">자주 묻는 질문</a></li>
				<li class="nav"><a class="nav" href="inquiry.do">1:1문의</a></li>
			</ul>
		</div>
	
		<div class="faqList">
			<h2>자주묻는 질문</h2>
			<div class="row g-3 mt-2">
				<select class="form-select" id="faqSelect">
					<option value="" <c:if test="${empty param.type}">selected</c:if>>전체</option>
					<option value="service" <c:if test="${param.type eq 'service' }">selected</c:if>>서비스 이용</option>
					<option value="site" <c:if test="${param.type eq 'site' }">selected</c:if>>사이트 이용</option>
				</select>
			</div>
			<table class="table table-hover mt-3">
				<tr>
					<th width="10%">글번호</th>
					<th width="25%">분류</th>
					<th width="65%">질문내용</th>
				</tr>
				<tbody id="faqBody">
					<tr id="1">
						<td class="no">1</td>
						<td class="no">사이트 이용</td>
						<td>1:1문의는 어디서 남길 수 있나요?</td>
					</tr>
					<tr id="panel1">
						<td colspan="3">
							<p class="faqTitle">√ 마이페이지 > 1:1문의하기 에서 접수 가능</p>
							<p class="faqContent">ㆍ단골의 희열 사이트 고객센터 > 1:1문의에서 1:1문의 접수 및
							답변 확인이 가능합니다.<br> ㆍ1:1문의 접수는 주말 및 공휴일 관계 없이 24시간 가능하며,문의사항 확인 후 업무
							시간 내 신속하게 도움 드리겠습니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
					<tr id="2">
						<td class="no">2</td>
						<td class="no">사이트 이용</td>
						<td>회원 탈퇴를 하고 다시 기존 아이디로 가입할 수 있나요?</td>
					</tr>
					<tr id="panel2">
						<td colspan="3">
							<p class="faqTitle">√기존 아이디 재가입 불가능</p>
							<p class="faqContent">ㆍ탈퇴 하신 후 기존 아이디로 재가입이 가능합니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
					<tr id="3">
						<td class="no">3</td>
						<td class="no">사이트 이용</td>
						<td>해시태그는 무엇인가요?</td>
					</tr>
					<tr id="panel3">
						<td colspan="3">
							<p class="faqTitle">√해시태그는 회원별 추천에 사용됩니다.</p>
							<p class="faqContent">ㆍ회원가입시 입력하신 해시태그는 회원별 추천에 사용됩니다.<br>
							ㆍ회원가입시 입력하시는 해시태그는 최대 3개 까지 등록가능 합니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>