<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<h3>글수정화면(modify_board.jsp)</h3>
<form action="modifyBoard.do">
<input type="hidden" value="${board_info.boardNo }" name="bno">
<input type="hidden" value="${page }" name="page">
<table class="table">
	<tr>
		<th>글번호</th>
		<td colspan="3"><c:out value="${board_info.boardNo }" /></td>
		<th>조회수</th>
		<td><c:out value="${board_info.viewCnt }" /></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="5"><input type="text" name="title" class="form-control" value="${board_info.title }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="5">
		<textarea name="content" class="form-control">${board_info.content }</textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><c:out value="${board_info.writer }" /></td>
		<th>작성일</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
				value="${board_info.creationDate }" /></td>
		<th>변경일</th>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
				value="${board_info.lastUpdateDate }" /></td>
	</tr>
	<tr>
		<td colspan="6" align="center"><input type="submit" value="저장"
			class="btn btn-success">
			<button type="button" class="btn btn-secondary">취소</button>
	    </td>
	</tr>
</table>
</form>

<jsp:include page="includes/footer.jsp" />