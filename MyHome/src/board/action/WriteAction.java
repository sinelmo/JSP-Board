package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.baorddao.BoardDAO;
import board.boarddto.BoardDTO;
import member.memberdto.MemberDTO;
import util.Action;

public class WriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = BoardDAO.getInstance();
		
		HttpSession session = request.getSession();
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		
		dto.setId(login.getId());
		dto.setName(login.getName());
		dto.setTitle(request.getParameter("title").toString());
		dto.setContent(request.getParameter("content").toString());
		dto.setFilename(request.getParameter("filename").toString());
		dto.setHit(0);
		
		boolean check = dao.write(dto);
		
		String msg = null;
		String url = null;
		
		if(check) {
			msg="글쓰기 성공! 목록으로..";
			url="/MyHome/board/list.brd";
		}else {
			msg="글쓰기 실패! 이전페이지로..";
			url="/MyHome/board/write.brd";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
	}
}
