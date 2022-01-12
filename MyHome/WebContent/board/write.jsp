<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<script>
	function checkWrite(){
		if(document.write.title.value==""){
			alert("제목을 입력하시오!");
			return false;
		}else if(document.write.content.value==""){
			alert("내용을 입력하시오!");
			return false;
		}
		
		return true;
	}
</script>
	<form action="/MyHome/board/checkWrite.brd" method="post" name="write" onsubmit="return checkWrite()">
		<table width="400px">
			<tr>
				<th>글제목</th>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows="20" cols="40" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>파일업로드</th>
				<td>
					<%-- 이 부분을 채우시오 --%>
					<input type="text" name="filename">
				</td>
			</tr>
		</table>
		
		<div style="width: 400px; padding-top: 20px;">
			<span style="float: right;">
				<button>글쓰기</button>
			</span>
		</div>
	</form>
<%@ include file="/layout/footer.jsp" %>