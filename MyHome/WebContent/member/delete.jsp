<%@page import="member.memberdao.MemberDAO"%>
<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("login");
	MemberDAO dao = MemberDAO.getInstance();
	if(request.getParameter("password").equals(dto.getPassword())){
		if(dao.delete(dto)){
			//session.removeAttribute("login"); 회원 탈퇴니까 더이상 정보가 필요하지 않기때문에 invalidate()로 정보를 지운다.
			session.invalidate();
			out.write("<script>");
			out.write("alert('회원 탈퇴가 성공적으로 완료되었습니다.');");
			out.write("location.href = '/MyHome/login/login.jsp';");
			out.write("</script>");
		}else{
			out.write("<script>");
			out.write("alert('회원 탈퇴가 실패하였습니다.');");
			out.write("location.href = '/MyHome/member/deleteForm.jsp';");
			out.write("</script>");
		}
	}else{
		out.write("<script>");
		out.write("alert('비밀번호가 틀렸습니다.');");
		out.write("location.href = '/MyHome/member/deleteForm.jsp';");
		out.write("</script>");
	}
	
%>