<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Order List</h1>
	<!-- 주문하기 item pk, session member pk -->
	<table border="1">
		<tr>
			<td>no</td>
			<td>orderDate</td>
			<td>itemNo</td>
			<td>name</td>
			<td>price</td>
		</tr>
		<c:forEach var="order" items="${orderList}">
			<tr>
				<td>${order.no}</td>
				<td>${order.orderDate}</td>
				<td>${order.itemNo}</td>
				<td>${order.name}</td>
				<td>${order.price}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${paging.currentPage > 1}">
		<a href="<%=request.getContextPath()%>/OrderListController?currentPage=${paging.currentPage-1}">
			<button type="button">이전</button></a>
	</c:if>
	<c:if test="${paging.currentPage < paging.lastPage}">
		<a href="<%=request.getContextPath()%>/OrderListController?currentPage=${paging.currentPage+1}">
			<button type="button">다음</button></a>
	</c:if>
</body>
</html>