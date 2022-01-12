package board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.baorddao.BoardDAO;
import board.boarddto.BoardDTO;
import util.Action;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		dto = dao.view(seq);
		
		request.setAttribute("dto", dto);

	}

}
