package carpick.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import carpick.board.model.*;

import static carpick.board.model.BoardSQL.*;


public class BoardDAO {
	private DataSource ds;//alternative to DriverManager
	BoardDAO(){//연결하고 싶은 데베를 작성
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {}
	}
	ArrayList<Board> list(){
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(LIST);
			while(rs.next()) {
				long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				Board board = new Board(seq, writer, email, subject, content, rdate);
				list.add(board);
			}
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}	
		}
	}
	public boolean insert(Board board){ // 구현
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1,board.getWriter());
			pstmt.setString(2,board.getEmail());
			pstmt.setString(3,board.getSubject());
			pstmt.setString(4,board.getContent());
			int i = pstmt.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException se){
			System.out.println("BoardDAO insert에서 오류 발생: "+se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
			}
	   }
	public Board content(long seq) {
	   	Board list = new Board();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where seq=?";
		ResultSet rs = null;
		if(seq != -1){
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, seq);
				rs = pstmt.executeQuery();
				while(rs.next()){
					//int seq1 = rs.getInt(1);
					String writer = rs.getString(2);
					String email = rs.getString(3);
					String subject = rs.getString(4);
					String content = rs.getString(5);
					list=new Board(seq, writer, email, subject, content,null);
				}
				return list;
			}catch(SQLException se){
				return null;
			}finally{
				try{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se){}
			}
		}
		return list;
   }
	public Board del(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		if(seq != -1){
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				pstmt.setLong(1, seq);
				pstmt.executeUpdate();
			}catch(SQLException se){
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {
				}
			}
		}
		return null;
	}
	public Board goupdate(long seq){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(seq != -1){
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(SELECT);
				pstmt.setLong(1, seq);
				rs = pstmt.executeQuery();
				while(rs.next()){
					String writer = rs.getString(2);
					String email = rs.getString(3);
					String subject = rs.getString(4);
					String content = rs.getString(5);
				
				Board board = new Board(seq, writer, email, subject, content, null);
				System.out.println("writer: "+writer);
				return board;
				}
			}catch(SQLException se) {
				System.out.println("DAO 오류 se: "+ se);
				return null;
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}	
			}
		}
		return null;
	}
	public boolean update(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1,board.getWriter());
			pstmt.setString(2,board.getSubject());
			pstmt.setString(3,board.getContent());
			pstmt.setLong(4,board.getSeq());
			int i = pstmt.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se){
			System.out.println("BoardDAO update에서 오류 발생: "+se);
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
			}
	}
	public Board getBoard(String email) {
		   Board board = new Board();
		   Connection con = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
	       String SQL = "SELECT * FROM board WHERE email = ?";
	       try {
	          pstmt = con.prepareStatement(SQL);
	          pstmt.setString(1, email);
	          rs = pstmt.executeQuery();
	          while(rs.next()){
					long seq = rs.getLong(1);
					String writer = rs.getString(2);
					//String email = rs.getString(3);
					String subject = rs.getString(4);
					String content = rs.getString(5);
					board = new Board(seq, writer, null, subject, content,null);
				}
				return board;
	       } catch (Exception e) {
	          e.printStackTrace();
	       }
	       return null; //db오류
	    }
}
