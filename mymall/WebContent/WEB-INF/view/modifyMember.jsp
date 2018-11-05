<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ModifyMember Form</h2>
	<form action="<%=request.getContextPath()%>/ModifyMemberController" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${loginMember.id}" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="level">
		                <option value="1">== 선택하세요 ==</option>
		                <option value="1">고객</option>
		                <option value="0">관리자</option>
	           		</select>
	           	</td>
			</tr>
		</table>
		<div>
			<a href="<%=request.getContextPath()%>/IndexController">
				<button type="button">취소</button></a>
			<input type="submit" value="정보수정">
		</div>
	</form>
</body>
</html>