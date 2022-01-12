package member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class UpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		//dto.setEmail(request.getParameter("email"));
		//dto.setTel1(request.getParameter("tel1"));
		//dto.setTel2(request.getParameter("tel2"));
		//dto.setTel3(request.getParameter("tel3"));
		
		MemberDTO dto = new MemberDTO();
		dto.setNo(login.getNo());
		dto.setEmail(request.getParameter("email"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3"));
		
		
		boolean check = MemberDAO.getInstance().updateMember(dto);
		
		String msg = null;
		String url = null;
		
		if(check){
			//session.setAttribute("login", login);
			login.setEmail(request.getParameter("email"));
			login.setTel1(request.getParameter("tel1"));
			login.setTel2(request.getParameter("tel2"));
			login.setTel3(request.getParameter("tel3"));
			msg = "수정완료!!MyPage로...";
			url = "/MyHome/member/myPage.jsp";
		}else{
			msg = "수정실패!!이전페이지로...";
			url = "/MyHome/member/updateForm.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
	}
}
