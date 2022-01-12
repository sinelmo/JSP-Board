<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
	<form action="/MyHome/board/modify.brd" method="post">
		<table width="400px">
			<tr>
				<th>번호</th>
				<td>
					${dto.seq }
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					${dto.id }
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					${dto.name }
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>
					${dto.hit }
				</td>
			</tr>
			<tr>
				<th>작성 날짜</th>
				<td>
					${dto.logtime }
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					${dto.title }
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					${dto.content }
				</td>
			</tr>
			<tr>
				<th>파일업로드</th>
				<td>
					${dto.filename }
				</td>
			</tr>
		</table>
		
		<div style="width: 400px; padding-top: 20px;">
			<span style="float: right;">
				<button>수정</button>
				<input type="button" value="삭제" onclick="location.href='/MyHome/board/delete.brd'">
			</span>
		</div>
	</form>
<%@ include file="/layout/footer.jsp" %>