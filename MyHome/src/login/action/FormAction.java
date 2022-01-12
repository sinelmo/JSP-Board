package login.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class FormAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
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
	}
}
