package carpick.board.model;

import java.util.ArrayList;

import carpick.board.model.*;

public class BoardService {
private BoardDAO dao;
	
	private static final BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	}
	public static BoardService getInstance() {
		return instance;		
	}
	public ArrayList<Board> listS(){
		return dao.list();
	}
	public boolean insertS(Board board){
		return dao.insert(board);
	}
	public Board contentS(long seq){
		return dao.content(seq);
	}
	public Board delS(long seq){
		return dao.del(seq);
		
	}
	public boolean updateS(Board board) {
		return dao.update(board);
	}
	public Board goupdateS(long seq){
		return dao.goupdate(seq);
	}
}
