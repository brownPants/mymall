<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<c:if test="${loginMember != null}">
		<c:if test="${loginMember.level == 0}">
			${loginMember.id} 관리자님 반갑습니다. <br>
			<a href="${pageContext.request.contextPath}/LogoutController">로그아웃</a>
			<a href="${pageContext.request.contextPath}/ItemListController">상품목록</a>
			<a href="${pageContext.request.contextPath}/OrderListController">주문목록</a>
			<a href="${pageContext.request.contextPath}/RemoveMemberController">관리자탈퇴</a>
		</c:if>
		<c:if test="${loginMember.level == 1}">
			${loginMember.id} 고객님 반갑습니다. <br>
			<a href="${pageContext.request.contextPath}/LogoutController">로그아웃</a>
			<a href="${pageContext.request.contextPath}/ItemListController">상품목록</a>
			<a href="${pageContext.request.contextPath}/OrderListController">주문목록</a>
			<a href="${pageContext.request.contextPath}/RemoveMemberController">회원탈퇴</a>
		</c:if>
	</c:if>
	<c:if test="${loginMember == null}">
		<a href="${pageContext.request.contextPath}/LoginController">로그인</a>
		<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
	</c:if>
</body>
</html>