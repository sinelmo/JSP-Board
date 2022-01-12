<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("test");
	request.setAttribute("name", name);
%>

	<h1>${name}</h1>
	
	
