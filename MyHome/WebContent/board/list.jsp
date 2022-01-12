<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<%-- 로그인시에만 글쓰기 버튼 보이게 하기 글 목록 없으면 작성한 글이 없습니다 띄우기 --%>

<form action="/MyHome/board/write.brd" method="post">
		<table width="400px">
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:choose>
				<c:when test="${boardList eq null }">
					<tr><th colspan="5">작성한 글이 없습니다.</th></tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${boardList }">
						<tr>
							<th>${dto.seq }</th>
							<th><a href="/MyHome/board/view.brd?seq=${dto.seq }">${dto.title }</a></th>
							<th>${dto.id }</th>
							<th>${dto.logtime }</th>
							<th>${dto.hit }</th>
						</tr>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</table>
	<div style="width: 400px; padding-top: 20px;">
		<span style="float: right;">
			<c:choose>
				<c:when test="${login eq null }">
				</c:when>
				<c:otherwise>
					<button>글쓰기</button>
				</c:otherwise>
			</c:choose>
		</span>
	</div>
</form>
<%@ include file="/layout/footer.jsp" %>
