package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.ListAction;
import board.action.ViewAction;
import board.action.WriteAction;
import member.action.JoinAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.brd")
public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Action action = null;
		ActionForward actionForward = null;
		String requestURL = request.getRequestURI().toString();
		
		int start = requestURL.lastIndexOf("/");
		int end = requestURL.lastIndexOf(".brd");
		
		String path = requestURL.substring(start + 1, end);
		
		switch(path) {
		case "list":
			action = new ListAction();
			actionForward = new ActionForward("/board/list.jsp", false);
			break;
		case "write":
			actionForward = new ActionForward("/MyHome/board/write.jsp", true);
			break;
		case "checkWrite":
			action = new WriteAction();
			actionForward = new ActionForward("/board/result.jsp", false);
		case "view":
			action = new ViewAction();
			actionForward = new ActionForward("/board/view.jsp", false);
				
		case "modify":
		}
		
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) {
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
