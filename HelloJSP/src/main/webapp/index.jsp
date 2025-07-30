<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="boardList.do"></jsp:forward>
	<h3>Hello, JSP</h3>
	
	<!-- 밑에 변수 선언하는거랑 같은 의미임 -->
	<c:set var="name" value="홍길동"></c:set>
	<c:out value="${name }"></c:out>
	
	<!-- null, "" 둘다 boolean에서 같은 결과를 출력함 -->
	<c:choose>
	<c:when test="${not empty name }">
	<p>정답</p>
	</c:when>	
	<c:otherwise>
	<p>오답</p>
	</c:otherwise>
	</c:choose>
	
	
	
	<!-- 반복문 forEach-->
	<c:forEach var="i" begin="1" end="5" step="1">
	<p>2 * ${i } = ${2 *i }</p>
	</c:forEach>
	
	<c:set var="age" value="19"></c:set>
	
	<c:if test="${age >= 20 }">
	<p>당신은 성년입니다</p>
	</c:if>
	
</body>
</html>