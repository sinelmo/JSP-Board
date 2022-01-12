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

public class DeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		MemberDAO dao = MemberDAO.getInstance();
		
		String msg = null;
		String url = null;
		
		if(request.getParameter("password").equals(dto.getPassword())){
			if(dao.delete(dto)){
				//session.removeAttribute("login"); 회원 탈퇴니까 더이상 정보가 필요하지 않기때문에 invalidate()로 정보를 지운다.
				session.invalidate();
				msg = "회원 탈퇴가 성공적으로 완료되었습니다.";
				url = "/MyHome/login/login.jsp";
			}else{
				msg = "회원 탈퇴가 실패하였습니다.";
				url = "/MyHome/member/deleteForm.jsp";
			}
		}else{
			msg = "비밀번호가 틀렸습니다.";
			url = "/MyHome/member/deleteForm.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}
}
