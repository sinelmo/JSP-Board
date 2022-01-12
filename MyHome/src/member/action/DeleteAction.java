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
				//session.removeAttribute("login"); ȸ�� Ż��ϱ� ���̻� ������ �ʿ����� �ʱ⶧���� invalidate()�� ������ �����.
				session.invalidate();
				msg = "ȸ�� Ż�� ���������� �Ϸ�Ǿ����ϴ�.";
				url = "/MyHome/login/login.jsp";
			}else{
				msg = "ȸ�� Ż�� �����Ͽ����ϴ�.";
				url = "/MyHome/member/deleteForm.jsp";
			}
		}else{
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
			url = "/MyHome/member/deleteForm.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}
}
