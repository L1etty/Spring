<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조건문 반복문</title>
</head>
<body>
	<h2>조건문, 반복문</h2>
	
	<h2>if else if</h2>
	<%-- 몸무게가 70이하면 치킨, 80이하면 셀러드, 그게 아니면 굶어 --%>
	<c:set var="weight" value="90"/>
	<c:choose>
		<c:when test="${weight <= 60 }">
			<h3>치킨</h3>
		</c:when>
		<c:when test="${weight <= 80 }">
			<h3>샐러드</h3>
		</c:when>
		<c:otherwise>
			<h4>굶어</h4>
		</c:otherwise>
	</c:choose>
	
	<h2>반복문</h2>
	
	<%-- for(int i = 0; i < 5; i++) { --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	
	<%-- for(String fruit:fruitList) --%>
	<c:forEach var="fruit" items="${fruitList}" varStatus="status">
		<h4>${fruit} ::::: ${status.count} ${status.index} ${status.first} ${status.last}</h4>
	</c:forEach>
	
</body>
</html>