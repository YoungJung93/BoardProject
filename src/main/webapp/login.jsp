<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function login() {
	var userId = document.getElementById("userId").value;
	console.log(userId);
	var userPassword = document.getElementById("userPassword").value;
	console.log(userPassword);
	
	var json = {"userId" : userId, "userPassword" : userPassword};
	$.ajax({
		url : "/login",
		type : "POST",
		data : JSON.stringify(json),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			console.log(data.status);
			alert('login 정보 전송완료');
		},
		error : function(err) {
			alert('login 실패');
		}
	})
}

</script>
<body>
	<table style="align : center;">
		<tr>
			<td><h2><strong>LOGIN</strong></h2></td>
		</tr>
		<tr>
			<td><input type="text" placeholder="ID" id="userId" name="userId"> </td>
		</tr>
		<tr>
			<td><input type="password" placeholder="PASSWORD" id="userPassword" name="userPassword"> </td>
		</tr>
		<tr>
			<td><button onclick="login()">Login</button></td>
		</tr>
	</table>
</body>
</html>