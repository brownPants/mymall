<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>DetailMember Form</h2>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${loginMember.id}</td>
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<c:if test="${loginMember.level == 0}">
					관리자
				</c:if>
				<c:if test="${loginMember.level == 1}">
					고객
				</c:if>
			</td>
		</tr>
	</table>

</body>
</html>