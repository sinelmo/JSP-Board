package board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.baorddao.BoardDAO;
import board.boarddto.BoardDTO;
import util.Action;

public class ListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = BoardDAO.getInstance();
		
		ArrayList<BoardDTO> boardList = dao.list();
		
		request.setAttribute("boardList", boardList);
		
	}
}
