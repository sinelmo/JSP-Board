package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class FormAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boolean check = false; //���̵���� ���̵� ������ true , ������ false
		
		String id = request.getParameter("id");
		
		if(id == null){
			//��Ű�� �˻�
			
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
	}
}
