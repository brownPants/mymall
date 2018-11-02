<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Item List</h1>
	<table border="1">
		<tr>
			<td>no</td>
			<td>name</td>
			<td>price</td>
			<td>주문</td>
		</tr>
		<c:forEach var="item" items="${itemList}">
			<tr>
				<td>${item.no}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td><a href="<%=request.getContextPath()%>/OrderController?itemNo=${item.no}"><button type="button">주문</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${paging.currentPage > 1}">
		<a href="<%=request.getContextPath()%>/ItemListController?currentPage=${paging.currentPage-1}">
			<button type="button">이전</button></a>
	</c:if>
	<c:if test="${paging.currentPage < paging.lastPage}">
		<a href="<%=request.getContextPath()%>/ItemListController?currentPage=${paging.currentPage+1}">
			<button type="button">다음</button></a>
	</c:if>
</body>
</html>