
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- 
<p>${ board_list}</p>
<p>${ paging}</p>
 -->


<!-- 검색 -->
<div class="center">
	<form action="memberList.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition == 'T' ? 'selected' : '' }>Mem_Id</option>
					<option value="W" ${searchCondition == 'W' ? 'selected' : '' }>Mem_Name</option>
					<option value="TW" ${searchCondition == 'TW' ? 'selected' : '' }>Mem_Id & Mem_Name</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" class="form-control" value="${keyword}">
			</div>
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn-success">
			</div>
		</div>
	</form>
</div>
<!--검색 end-->
<h3>멤버 목록</h3>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Mem_Id</th>
			<th>Mem_Pw</th>
			<th>Mem_Name</th>
			<th>Respon</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="member" items="${board_list }">

			<tr>
				<td><c:out value="${member.memberId }" /></td>
				<!-- 공백도 하나의 값이니까 잘 보고 넣자      특히 밑에 홑따옴표 앞에 요런 부분 -->
				<td>${member.memberPw }</td>
				<td>${member.memberName }</td>
				<td>${member.responsibility }</td>
			</tr>
<img src="" >
		</c:forEach>
	</tbody>
</table>
<!-- paging.. -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<!-- 이전페이지. -->
		<c:choose>
			<c:when test="${paging.previous }">
				<li class="page-item"><a class="page-link"
					href="memberList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${paging.start - 1 }">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>

		<!-- paging정보를 받아서 링크생성. -->
		<c:forEach var="p" begin="${paging.start}" end="${paging.end}">
			<c:choose>
				<c:when test="${paging.currPage eq p }">
					<li class="page-item active" aria-current="page"><span
						class="page-link">${p }</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="memberList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${p }">${p }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 이후페이지. -->
		<c:choose>
			<c:when test="${paging.next }">
				<li class="page-item"><a class="page-link"
					href="memberList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${paging.end + 1 }">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Next</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</nav>

