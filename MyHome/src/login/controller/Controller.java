package login.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.CheckAction;
import login.action.FormAction;
import login.action.LogoutAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.do") // /MyHome/ .... .do
public class Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Action action = null;
		ActionForward actionForward = null;
		
		String requestURL = request.getRequestURI().toString();
		
		//System.out.println(requestURL); // /MyHome/login/login.do
		
		int start = requestURL.lastIndexOf("/");
		int end = requestURL.lastIndexOf(".do");
		
		String path = requestURL.substring(start + 1, end);
		
		//System.out.println(path);
		
		//RequestDispatcher rd = null;
		
		switch(path) {
		case "login": 
			action = new FormAction();
			actionForward = new ActionForward("/login/form.jsp", false);
//			new FormAction().execute(request, response);
//			rd = request.getRequestDispatcher("/login/form.jsp");
//			rd.forward(request, response);
			break;
		case "check":
			action = new CheckAction();
			actionForward = new ActionForward("/login/result.jsp", false);
//			new CheckAction().execute(request, response);
//			rd = request.getRequestDispatcher("/login/result.jsp");
//			rd.forward(request, response);
			break;
		case "logout":
			action = new LogoutAction();
			actionForward = new ActionForward("/MyHome/login/logout.jsp", true);
			break;
		}
		
		if(action != null) { // 실행
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) { // forward, redirect 실행
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
		
	}
}
