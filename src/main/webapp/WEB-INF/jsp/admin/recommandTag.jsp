<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<title>추천태그_관리자화면</title>
	<script type="text/javascript">
		function applyTag(type){ // 태그 적용
			var params = {
				atype : 'main' + type,
				avalue : $('#select_main' + type).val()
			};
		
			$.ajax({
		        url : "/admin/insertMain.do",
		        type : "post",
		        dataType : "json",
		        data : params,
		        success : function(response) {
		            console.log(response);
		            if( response.code != "3001"){
		            	alert(response.message);
		            }else{
		            	location.reload();
		            }
		        }, error : function(jqXHR, status, e) {
		            console.error(status + " : " + e);
		        }
		    });
		}
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="p-5">
			<h3>추천태그 설정</h3>
			<table class="table table-borderless">
				<tbody>
				<c:if test="${fn:length(themes) gt 0}">
					<!-- 추천1 부분 -->
					<tr>
						<td>
							<!-- 테마태그 드롭다운 버튼 -->
							<div class="row g-3">
								<div class="col-md-1">
									추천1
								</div>
								<div class="col">
									<select id="select_main1" class="form-select" name="main1">
										<c:forEach var="theme" items="${themes}" varStatus="status">
											<option value="<c:out value='${theme.avalue}'/>" <c:if test="${main1.avalue eq theme.avalue}"> selected</c:if>><c:out value='${theme.avalue}'/></option>
										</c:forEach>
									</select>
								</div>
								<div class="col">
									<button class="btn btn-outline-primary" type="button" onclick="applyTag(1);">적용하기</button>
								</div>
							</div>
						</td>
					</tr>
					<!-- 추천2 부분 -->
					<tr>
						<td>
							<!-- 테마태그 드롭다운 버튼 -->
							<div class="row g-3">
								<div class="col-md-1">
									추천2
								</div>
								<div class="col">
									<select id="select_main2" class="form-select" name="main2">
										<c:forEach var="theme" items="${themes}" varStatus="status">
											<option value="<c:out value='${theme.avalue}'/>" <c:if test="${main2.avalue eq theme.avalue}">selected</c:if>><c:out value='${theme.avalue}'/></option>
										</c:forEach>
									</select>
								</div>
								<div class="col">
									<button class="btn btn-outline-primary" type="button" onclick="applyTag(2);">적용하기</button>
								</div>
							</div>
						</td>
					</tr>
				</c:if>
				<c:if test="${fn:length(themes) eq 0}">
					<tr>
						<td>등록된 태그가 없습니다. 태그를 먼저 등록 해주세요</td>
					</tr>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>