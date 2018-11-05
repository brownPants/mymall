<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>RemoveMember Form</h2>
	<form action="<%=request.getContextPath()%>/RemoveMemberController" method="post">
		<table border="1">
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
		</table>
		<div>
			<a href="<%=request.getContextPath()%>/IndexController">
				<button type="button">취소</button></a>
			<input type="submit" value="회원탈퇴">
		</div>
	</form>
</body>
</html>