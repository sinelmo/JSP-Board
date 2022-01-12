package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class CheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3")); 	
		
		MemberDAO dao = MemberDAO.getInstance();
		
		boolean check = dao.insert(dto);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");


		PrintWriter out = response.getWriter();
		
		out.write("<script>");
		if(check){
			out.write("alert('회원 가입에 성공하셧습니다..로그인페이지로..');");
			out.write("location.href='/MyHome/login/login.jsp?id=" + dto.getId() + "';");
		}else{
			out.write("alert('회원가입에 실패하셨습니다...이전페이지로..');");
			out.write("history.back();");
		}
		out.write("</script>");	

	}

}
