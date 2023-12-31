<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
</head>
<body>
	<h1>사용자 추가</h1>
		<label>이름</label><input type="text" name="name" id="nameInput"><br>
		<label>생년월일</label><input type="text" name="birthday" id="birthdayInput"><br>
		<label>이메일</label><input type="text" name="email" id="emailInput"><button type="button" id="duplicateBtn">중복확인</button><br>
		<label>자기소개</label><br><textarea cols="50" rows="5" name="introduce" id="introduceInput"></textarea><br>
		<button type="button" id="addBtn""addBtn">추가</button>
	
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>	
	
	<script>
		
		$(document).ready(function() {
			
			$("#duplicateBtn").on("click", function(){
				let email = $("#emailInput").val();
				
				if(email == ""){
					alert("이메일 입력하세요");
					return;
				}
				
				$.ajax({
					
					type:"get"
					,url:"/ajax/user/email_confirm"
					,data:{"email":email}
					,success:function(data){
						if(data.isDuplicate){
							alert("이메일이 중복되었습니다.");
						}else{
							alert("사용가능한 이메일입니다.")
						}
					}
					,error:function(){
						alert("중복확인 에러");
					}
					
				});
				
				
			});
			
			$("#addBtn").on("click", function() {
				//유효성 검사
				
				let name = $("#nameInput").val();
				let birthday = $("#birthdayInput").val();
				let email = $("#emailInput").val();
				let introduce = $("#introduceInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요.");
					return;
				}
				if(birthday == ""){
					alert("생년월일을 입력하세요.");
					return;
				}
				if(email == ""){
					alert("이메일을 입력하세요.");
					return;
				}
				if(introduce == ""){
					alert("자기소개를 입력하세요.");
					return;
				}
				
				$.ajax({
					type:"get"
					,url:"/ajax/user/add"
					,data:{"name":name, "birthday":birthday, "email":email, "introduce":introduce}
					,success:function(data){
						if(data.result == "success"){
							// 리스트 페이지로 리동
							location.href="/ajax/user/list";
						}else{
							alert("insert fail...");
						}
					}
					,error:function(){
						alert("insert error...");
					}
					
				});
				
			});
			
		});
	
	</script>
	
</body>
</html>