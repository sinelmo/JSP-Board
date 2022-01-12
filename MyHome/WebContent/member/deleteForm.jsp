<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "/layout/header.jsp" %>
<div align="center">
	<form action="delete.me" method="post">
		<table style="width :250px;">
			<tr>
				<td>${login.name }님의 비밀번호 확인</td>
			</tr>
			<tr>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
	
		<div style="width: 250px; padding-top: 20px;">
			<span style="float: right;">
				<input type="submit" value = "회원탈퇴" >
			</span>
				
		</div>
	</form>
</div>
<%@include file = "/layout/footer.jsp" %>