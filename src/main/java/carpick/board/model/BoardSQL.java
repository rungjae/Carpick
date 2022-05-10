package carpick.board.model;

public class BoardSQL {
	static final String LIST = "select * from BOARD order by SEQ desc";
	static final String INSERT = "insert into board values(BOARD_SEQ.nextval, ?,?,?,?,SYSDATE)";
	static final String SELECT ="select * from board where seq=?";
	static final String UPDATE = "update board set writer=?, subject=?, content=? where seq=?";
	static final String DELETE = "delete from board where seq=?";

}
