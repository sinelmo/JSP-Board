package board.baorddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.boarddto.BoardDTO;
import member.memberdto.MemberDTO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static DataSource ds;
	
	private static BoardDAO instance;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board order by seq DESC";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setHit(rs.getInt("hit"));
				dto.setLogtime(rs.getString("logtime"));
				list.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public BoardDTO view(int seq) {
		BoardDTO dto = new BoardDTO();
		String sql = "select * from board where seq=?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
			
			dto = makeDTO(rs);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	private BoardDTO makeDTO(ResultSet rs) {
		BoardDTO dto = null;
		
		try {
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setFilename(rs.getString("filename"));
				dto.setHit(rs.getInt("hit"));
				dto.setLogtime(rs.getString("logtime"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public boolean write(BoardDTO dto) {
		boolean check = false;
		
		String sql = "insert into board(seq, id, name, title, content, filename, hit)"
				+ " values(board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getTitle());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getFilename());
			ps.setInt(6, dto.getHit());
			
			if(ps.executeUpdate()!=0) {
				check = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
}
