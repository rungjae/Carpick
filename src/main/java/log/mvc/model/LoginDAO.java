package log.mvc.model;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
import static log.mvc.model.LoginSQL.SEL;

class LoginDAO {
	private DataSource ds;
	LoginDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	Member getMember(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SEL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//String email = rs.getString(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);

				return new Member(name, email, pwd);
			}else {
				return null;
			}
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	boolean insert(Member dto) { //±¸Çö
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      String sql = LoginSQL.INSERT;
	      try{
	         con = ds.getConnection();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, dto.getEmail());
	         pstmt.setString(2, dto.getName());
	         pstmt.setString(3, dto.getPwd());
	         int i = pstmt.executeUpdate();
	         if(i>0){
	            return true;
	         }else{
	            return false;
	         }
	      }catch(SQLException se){
	         System.out.println("#LoginDAO insert() se: " + se);
	         return false;
	      }finally{
	         try{
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException se){}
	      }
	   }
	}
