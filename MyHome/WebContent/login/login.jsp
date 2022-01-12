<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean check = false; //아이디기억기 아이디가 있으면 true , 없으면 false
	
	String id = request.getParameter("id");
	
	if(id == null){
		//쿠키값 검색
		
		Cookie[] cks = request.getCookies();
		
		if(cks != null){
			for(Cookie ck : cks){
				if(ck.getName().equals("ckid")){
					id = ck.getValue();
					check = true;
					break;
				}
			}
		}
	}
	

	
	request.setAttribute("id", id);
	request.setAttribute("check", check);
	
	pageContext.forward("/login/form.jsp");
	
%>