<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입_사용자</title>
	<link rel="stylesheet" href="/css/signup.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//id 특수문자 제외
			$("#mid").on("keyup",function(){
				 re = /[~!@\#$%^&*\()\-=+_' ]/gi; 
				 var temp = $("#mid").val();
				 
				//특수문자가 포함되면 삭제하여 값으로 다시셋팅
				 if(re.test(temp)){
				 	$("#mid").val(temp.replace(re,"")); 
				 } 
			});
			
			//pw 공백 제외
			$("#pwd").on("keyup",function(){
				 re = /[ ]/gi;
				 var temp = $("#pwd").val();
				 //공백이 포함되면 삭제하여 값으로 다시셋팅
				 if(re.test(temp)){
				 	$("#pwd").val(temp.replace(re,"")); 
				 } 
			});
			
			//pwCheck 공백 제외
			$("#pwdCheck").on("keyup",function(){
				 re = /[ ]/gi; 
				 var temp = $("#pwdCheck").val();
				 //공백이 포함되면 삭제하여 값으로 다시셋팅
				 if(re.test(temp)){
				 	$("#pwdCheck").val(temp.replace(re,"")); 
				 } 
			});
			
			//중복체크
			$("#mid").on("blur",function(){
				var mid = $('#mid').val();
				var params = {
					mid : mid
				};
				
				if(mid == ''){
					$('#mid').removeClass('is-valid');
					$('#mid').addClass('is-invalid');
				}else{
					$.ajax({
						url : "/login/checkIdMember.do",
						type : "post",
						dataType : "json",
						data : params,
						success : function(response) {
							if (response.code != "3001") {
								$('#mid').removeClass('is-valid');
								$('#mid').addClass('is-invalid');
							} else {
								$('#mid').removeClass('is-invalid');
								$('#mid').addClass('is-valid');
							}
						}
					});
				}
			});
			
			//비밀번호 체크
			$('#pwd').blur(function(){
				if($('#pwd').val() == ''){
					$('#pwd').removeClass('is-valid');
					$('#pwd').addClass('is-invalid');
					alert('비밀번호를 입력해주세요');
				}else{
					$('#pwd').removeClass('is-invalid');
					$('#pwd').addClass('is-valid');
				}
			});
			
			//비밀번호 확인 체크
			$('#pwdCheck').blur(function(){
				if($('#pwdCheck').val() == ''){
					$('#pwdCheck').removeClass('is-valid');
					$('#pwdCheck').addClass('is-invalid');
					alert('비밀번호 확인을 입력해주세요');
				}else{
					if(($('#pwd').val()) == ($('#pwdCheck').val())){
						$('#pwdCheck').removeClass('is-invalid');
						$('#pwdCheck').addClass('is-valid');
					}else{
						$('#pwdCheck').removeClass('is-valid');
						$('#pwdCheck').addClass('is-invalid');
						alert("비밀번호가 일치하지 않습니다");
					}
				}
				
			});
		});
	</script>
	<script type="text/javascript">
		var sel_files = [];
		
		$(document).ready(function(){
			$("#uploadFile").on("change",SelectImg);
		});
		function SelectImg(e){//이미지 미리보기
			var files=e.target.files;
			var filesArr = Array.prototype.slice.call(files);
			
			filesArr.forEach(function(f){
				sel_file = f;
				var reader = new FileReader();
				reader.onload = function(e){
					$("#img").attr("src",e.target.result);
				}
				reader.readAsDataURL(f);
			});
		}
		function goPopup(){
			// 주소검색을 수행할 팝업 페이지를 호출합니다.
			var pop = window.open("jusoPopup.do?index=0","pop","width=570,height=420, scrollbars=yes, resizable=yes,left=400,top=300");
		}
		function prefer1(){
			var pop = window.open("jusoPopup.do?index=1","pop","width=570,height=420, scrollbars=yes, resizable=yes,left=400,top=300");
		}
		function prefer2(){
			var pop = window.open("jusoPopup.do?index=2","pop","width=570,height=420, scrollbars=yes, resizable=yes,left=400,top=300");
		}
	
		function jusoCallBack(roadAddrPart1,addrDetail,index){ 
			console.log(roadAddrPart1 + "," + addrDetail + "," +index);
			switch (index) {
			case "0":
				document.getElementById("useraddr").value = roadAddrPart1;    
				document.getElementById("useraddrDetail").value = addrDetail;    
				break;
			case "1":
				document.getElementById("preferaddr").value = roadAddrPart1;    
				break;
			case "2":
				document.getElementById("preferaddr2").value = roadAddrPart1;    
				break;
			}
		}
		
		function addMember(){ //회원가입
			if(formCheck()){
				if(confirm('가입 하시겠습니까?')){
					var form = $('#signUpForm')[0];
				    var formData = new FormData(form);
				    
					$.ajax({
				        url : "/login/signUpAct.do",
				        enctype: 'multipart/form-data',
				        type : "post",
				        dataType : "json",
				        data : formData,
				        processData : false,
				        contentType : false,
				        cache : false,
				        success : function(response) {
				            console.log(response);
				            if( response.code != "3001"){
				            	alert('가입에 실패하였습니다.');
				            }else{
				            	alert('가입이 완료되었습니다.');
				            	location.href = '/login/loginForm.do';
				            }
				        }, error : function(jqXHR, status, e) {
				            console.error(status + " : " + e);
				        }
				    });
				}
			}
		}
		
		function addTag(){ //태그 추가
			var tagVal = $('#ttag').val();
			var checkVal = $('#themeTag_'+tagVal).length;
			var tagStatus = $('#ttag option:checked').prop('disabled');
			if(checkVal){
				alert('중복된 태그 입니다. 다시 선택해주세요');
			}else{
				var tagText = $('#ttag option:checked').text();
				var tagList = $('#themeTag').text();
				var deleteBtn = '<span style="margin-left:20px;" id="themeTag_'+tagVal+'">';
				deleteBtn += '<input type="hidden" name="mtag" value="'+tagVal+'">'+tagText;
				deleteBtn += '<button class="delBtn" type="button" onClick="delTag('+tagVal+')"><img class="cancelImg" src="/jsp/cancel.png"></button>';
				deleteBtn += '</span>';
				$('#tagDiv').append(deleteBtn);
			}
		}
		
		function delTag(val){ //태그 삭제
			$('#themeTag_'+val).remove();
		}
		
		function formCheck(){ //폼 체크
			if($('#mid').val() == ''){
				alert('아이디를 입력해주세요.');
				$('#mid').focus();
				return false;
			}else if($('#mid').hasClass('is-invalid')){
				alert('중복된 아이디입니다.');
				$('#mid').focus();
				return false;
			}else if($('#pwd').val() == ''){
				alert("비밀번호를 입력해주세요.");
				$('#pwd').focus();
				return false;
			}else if($('#pwdCheck').val() == ''){
				alert("비밀번호 확인을 입력해주세요.");
				$('#pwdCheck').focus();
				return false;
			}else if($('#pwd').val() != $('#pwdCheck').val()){
				alert("비밀번호가 일치하지 않습니다.");
				$('#pwdCheck').focus();
				return false;
			}else if($('#mphone').val() == ''){
				alert("전화번호를 입력해주세요.");
				$('#mphone').focus();
				return false;
			}else if($('#address').val() == ''){
				alert("주소를 입력해주세요.");
				$('#address').focus();
				return false;
			}else{
				return true;
			}
		}
	</script>
</head>
<body>
<div class="cotn_principal">
	<div class="cont_centrar">
  		<div class="cont_login">
			<div class="cont_forms cont_forms_active_sign_up" >
				<div class="cont_form_sign_up">
					<a href="javascript:history.back();">이전</a>
					<h2>일반 가입</h2>
					<input type="text" id="mid" name="mid" maxlength="10" placeholder="아이디(특수문자 없이 10자이내)" onKeyup="this.value=this.value.replace(/^[A-Za-z0-9]$/,'');"/>
					<input type="password" id="pwd" name="mpw" maxlength="13" placeholder="비밀번호(공백없이 13자이내)" onKeyup="this.value=this.value.replace(/^[A-Za-z0-9]$/,'');"/>
					<input type="password" id="pwdCheck" maxlength="13" placeholder="비밀번호 확인(공백없이 13자이내)">
						
					<input type="text" id="mphone" name="mphone"  maxlength="11" placeholder="번호(-)제외  11자리이내" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
					
					<input type="text" id="useraddr" name="maddress" placeholder="주소"/>
					<input type="text" id="useraddrDetail" name="maddress_d" placeholder="상세주소"/>
					
					<input type="text" id="preferaddr" name="marea1" readonly="readonly" placeholder="선호하는 주소1" onclick="prefer1()"/>
					<input type="text" id="preferaddr2" name="marea2" readonly="readonly" placeholder="선호하는 주소2" onclick="prefer2()"/>
					
					<div id="tagDiv"></div>
					<select id="ttag" class="selectBox">
						<c:forEach var="themeTag" items="${themeList}">
							<option value="${themeTag.anum}">#${themeTag.avalue}</option>
						</c:forEach>
						<c:if test="${empty themeList}">
							<option selected disabled>태그 없음</option>
						</c:if>
					</select>
					
					<button class="btn_search" type="button" onclick="addTag()">추가</button>
					<div class="cont_ba_opcitiy"><p>해시태그는 회원별 추천에 사용됩니다.<br/> ※태그최대 등록 갯수: 3개</p></div>
					
					<img id="img" src="myPage.png" width=100 height=100>
					<input id="uploadFile" type="file" name="uploadFile">
					
					<button class="btn_sign_up" onclick="addMember()">SIGN UP</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>