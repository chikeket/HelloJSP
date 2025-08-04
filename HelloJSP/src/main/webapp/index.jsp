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
	
	
	
	
	
	<!-- 반복문 forEach-->
	<c:forEach var="i" begin="1" end="5" step="1">
	<p>2 * ${i } = ${2 *i }</p>
	</c:forEach>
	
	<c:set var="age" value="19"></c:set>
	
	<c:if test="${age >= 20 }">
	<p>당신은 성년입니다</p>
	</c:if>
	
	<!-- elseif에 해당  when 여러번 쓰는게 else if임-->
	<!-- else에 해당 -->
	
	<c:choose>
	<c:when test="${age >= 30 }">
	<p style="color: red;">어른</p>
	</c:when>
	<c:when test="${age >= 20 }">
	<p style="color: red;">청년</p>
	</c:when>
	<c:otherwise>
	<p style="color: green;">미성년</p>
	</c:otherwise>
	</c:choose>
	
	<c:forEach var="p" begin="1" end="5" step="1">
	<p>2 * ${i } = ${2 *i }</p>
	</c:forEach>
	
	<c:forEach var="p" begin="${paging.start}" end="${paging.end}">
	<p>2 * ${i } = ${2 *i }</p>
	</c:forEach>
	
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
	
</body>
</html>