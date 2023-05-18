<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>추천태그_관리자화면</title>
	<script type="text/javascript">
		function applyTag(type){ // 태그 적용
			if(type == 1){ //main1
				location.href="selectMain.do?atype=main1&avalue="+$('#select_main1').val();
			}else{ //main2
				location.href="selectMain.do?atype=main2&avalue="+$('#select_main2').val();
			}
		}
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="p-5">
			<h3>추천태그 설정</h3>
			<table class="table">
			<c:if test="${themesCnt gt 0}">
				<!-- 추천1 부분 -->
				<tr>
					<td>추천1</td>
					<td><c:out value="${main1.avalue}" /></td>
					<td><!-- 테마태그 드롭다운 버튼 -->
						<select id="select_main1" class="inputText w300" name="main1" >
							<c:forEach var="theme" items="${themes}" varStatus="status">
								<option value="<c:out value='${theme.avalue}'/>" <c:if test="${main1.avalue eq theme.avalue}"> selected</c:if>><c:out value='${theme.avalue}'/></option>
							</c:forEach>
						</select>
					</td>
					<td>
						<button class="btn-view" type="button" onclick="applyTag(1); return false;">적용하기</button>
					</td>
				</tr>
				<!-- 추천2 부분 -->
				<tr>
					<td>추천2</td>
					<td><c:out value="${main2.avalue}" /></td>
					<td>
						<!-- 테마태그 드롭다운 버튼 -->
						<select id="select_main2"  class="inputText w300" name="main2" >
							<c:forEach var="theme" items="${themes}" varStatus="status">
								<option value="<c:out value='${theme.avalue}'/>" <c:if test="${main2.avalue eq theme.avalue}">selected</c:if>><c:out value='${theme.avalue}'/></option>
							</c:forEach>
						</select>
					</td>
					<td>
						<button class="btn-view" type="button" onclick="applyTag(2); return false;">적용하기</button>
					</td>
				</tr>
			</c:if>
			<c:if test="${themesCnt eq 0}">
				<tr>
					<td>등록된 태그가 없습니다. 태그를 먼저 등록 해주세요</td>
				</tr>
			</c:if>
		</table>
		</div>
	</div>
</body>
</html>