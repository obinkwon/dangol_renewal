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
			
			for(var i =1; i<7;i++){
				$('#panel'+i).hide();
			/* 	$('#'+i).click(function(){
					$('#panel'+i).slideDown("fast");	
				}); 
			*/
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
			$('#4').click(function(){
				$('#panel4').slideToggle();	
			})
			$('#5').click(function(){
				$('#panel5').slideToggle();	
			})
			$('#6').click(function(){
				$('#panel6').slideToggle();	
			}) 
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="p-5">
			<ul class="nav nav-pills">
				<li class="nav-item"><a href="#" class="nav-link">고객센터</a></li>
				<li class="nav-item"><a href="faq.do" class="nav-link active">자주 묻는 질문</a></li>
				<li class="nav-item"><a href="inquiry.do" class="nav-link" >1:1문의</a></li>
			</ul>
			
			<h2>자주묻는 질문</h2>
			<div class="row g-3 mt-2">
				<select class="form-select" id="faqSelect">
					<option value="" <c:if test="${empty param.type}">selected</c:if>>전체</option>
					<option value="service" <c:if test="${param.type eq 'service' }">selected</c:if>>서비스 이용</option>
					<option value="site" <c:if test="${param.type eq 'site' }">selected</c:if>>사이트 이용</option>
				</select>
			</div>
			<table class="table table-hover mt-3" >
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
						<td class="no">서비스 이용</td>
						<td>멤버십 할인 기준은 어떻게 되나요?</td>
					</tr>
					<tr id="panel2">
						<td colspan="3">
							<p class="faqTitle">√ 회사소개 > 등급별 혜택에서 확인 가능</p>
							<p class="faqContent">ㆍ멤버십은 매장별 이용횟수로 산출됩니다.<br>ㆍ이용횟수가 12회 이하인 경우 범골등급, 24회 이하인 경우 진골등급, 48회 이하인 경우 성골등급, 48회 초과인 경우 단골등급에 해당됩니다.<br>ㆍ총 구매건수는 리뷰작성 기준입니다.<br>ㆍ혜택은 매장 별로 다를 수 있습니다.
							</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
					<tr id="3">
						<td class="no">3</td>
						<td class="no">서비스 이용</td>
						<td>멤버십 할인 기준은 각 매장마다 다른가요?</td>
					</tr>
					<tr id="panel3">
						<td colspan="3">
							<p class="faqTitle">√ 멤버십 할인은 매장/지점별로 상이 할 수 있습니다.</p>
							<p class="faqContent">ㆍ멤버십은 매장별 이용횟수로 산출됩니다.<br>ㆍ혜택은 매장 별로 다를 수 있습니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
					<tr id="4">
						<td class="no">4</td>
						<td class="no">사이트 이용</td>
						<td>회원 탈퇴를 하고 다시 기존 아이디로 가입할 수 있나요?</td>
					</tr>
					<tr id="panel4">
						<td colspan="3">
							<p class="faqTitle">√기존 아이디 재가입 불가능</p>
							<p class="faqContent">ㆍ탈퇴 하신 후 기존 아이디로 재가입이 가능합니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
					<tr id="5">
						<td class="no">5</td>
						<td class="no">사이트 이용</td>
						<td>해시태그는 무엇인가요?</td>
					</tr>
					<tr id="panel5">
						<td colspan="3">
							<p class="faqTitle">√해시태그는 회원별 추천에 사용됩니다.</p>
							<p class="faqContent">ㆍ회원가입시 입력하신 해시태그는 회원별 추천에 사용됩니다.<br>
							ㆍ회원가입시 입력하시는 해시태그는 최대 3개 까지 등록가능 합니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
					<tr id="6">
						<td class="no">6</td>
						<td class="no">서비스 이용</td>
						<td>후기를 꼭 작성해야 하나요?</td>
					</tr>
					<tr id="panel6">
						<td colspan="3">
							<p class="faqTitle">√후기작성은 필수 사항이 아닙니다.</p>
							<p class="faqContent">ㆍ이용후기 작성은 필수사항이 아닙니다.그러나 후기를 작성하셔야만 이용횟수가 산정되어 매장별 혜택을 받을수 있습니다.</p>
							<p class="faq">답변이 충분하지 않으셨다면, 1:1문의를 이용해 주세요.</p>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>