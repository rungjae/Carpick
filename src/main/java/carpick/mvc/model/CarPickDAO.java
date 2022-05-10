package carpick.mvc.model;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
import javax.servlet.http.HttpServletRequest;

import mvc.domain.CarPickDTO;

public class CarPickDAO {
	DataSource ds;
	ArrayList<String> tempList = new ArrayList<String>(); //����� ���ð� �ӽ� ����
	CarPickDAO(){
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException n){}
	}
	//favor
	   ArrayList<CarPickDTO> favorResult(String param0, String param1){
	      ArrayList<CarPickDTO> result = new ArrayList<CarPickDTO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      ResultSet rs2 = null;
	      System.out.println("favorResult ���� list size :"+ tempList.size());
	      try{
	         conn = ds.getConnection();
	         
	         if(param0.equals("production")) { //���� ������ ������ �Ͻ�
	            tempList.clear();//ù���۽� �ʱ�ȭ
	            if(tempList.size() >= 1){// ���缱�ð��� �������������
	               tempList.set(0, param1);//1��° ���� ����
	            }else {
	               tempList.add(param1); //������ ���ð� ����
	            }
	         }else if(param0.equals("brand")) { // ���� ������ �귣�� �Ͻ�
	            if(tempList.size() >= 2){// ���缱�ð��� �������������
	               tempList.set(1, param1);//2��° ���� ����
	            }else {
	               tempList.add(param1);
	            }
	         }else if(param0.equals("cartype")) { // ���� ������ �����Ͻ�
	            if(tempList.size() >= 3){// ���缱�ð��� �������������
	               if(tempList.size() >= 4) {
	                  tempList.remove(2);
	                  tempList.remove(3);
	                  tempList.add(param1);
	               }else {
	                  tempList.set(2, param1); //3��° ���� ����
	               }
	            }else {
	               tempList.add(param1);
	            }
	            pstmt = conn.prepareStatement(CarPickSQL.SELECT_CARTYPE_ALL);
	            System.out.println("list 1(����/�������ð�) : "+ tempList.get(0));
	            System.out.println("list 2(�귣�弱�ð�) : "+ tempList.get(1));
	            System.out.println("list 3(������) : "+ tempList.get(2));
	            System.out.println("favorResult �� list size :"+ tempList.size());
	            pstmt.setString(1, tempList.get(0));
	            pstmt.setString(2, tempList.get(1));
	            pstmt.setString(3, tempList.get(2));
	            rs = pstmt.executeQuery();
	            while(rs.next()){
	               int car_id = rs.getInt("CAR_ID");
	               String model_name = rs.getString("MODEL_NAME");
	               String car_pic = rs.getString("CAR_PIC");
	               int price_id = rs.getInt("PRICE_ID");
	               int brand_id = rs.getInt("BRAND_ID");
	               int cartype_id = rs.getInt("CARTYPE_ID");
	               int production_id = rs.getInt("PRODUCTION_ID");
	               String years = rs.getString("YEARS");
	               int price = rs.getInt("PRICE");
	               String fuel = rs.getString("FUEL");
	               String effiiency = rs.getString("EFFICIENCY");
	               String output = rs.getString("OUTPUT");
	               String exh = rs.getString("EXH");
	               String engine = rs.getString("ENGINE");
	               String shift = rs.getString("SHIFT");
	               String length = rs.getString("LENGTH");
	               String heigth = rs.getString("HEIGHT");
	               String width = rs.getString("WIDTH");
	               String wheelbase = rs.getString("WHEELBASE");
	         
	               CarPickDTO dto = new CarPickDTO(car_id, model_name, car_pic, price_id, brand_id, cartype_id,
	                     production_id, years, price, fuel, effiiency, output, exh,
	                     engine, shift, length, heigth, width, wheelbase);
	               result.add(dto);
	            }
	         }
	         return result;
	      }catch(SQLException s){
	         System.out.println(s);
	         return null;
	      }finally{
	         try{
	            if(rs2 != null) rs.close();
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch(SQLException s){}
	      }
	   }
	   //price favor
	   ArrayList<CarPickDTO> priceResult(String param0, String param1, String param2){ //���� ����Ʈ ��� ����
	      ArrayList<CarPickDTO> result = new ArrayList<CarPickDTO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      ResultSet rs2 = null;
	      System.out.println("priceResult ���� list size :"+ tempList.size());
	      try{
	         conn = ds.getConnection();
	         
	         if(param0.equals("price")) { //������ ���� ������
	            if(tempList.size() >= 3){// ���缱�ð��� �������������
	               if(tempList.size() == 3) {
	                  tempList.remove(2);
	                  tempList.add(param1);
	                  tempList.add(param2);
	               }else {
	                  tempList.set(2, param1);
	                  tempList.set(3, param2);
	               }
	            }else {
	               tempList.add(param1);
	               tempList.add(param2);
	            }
	            pstmt = conn.prepareStatement(CarPickSQL.SELECT_PRICE_ALL);
	         }
	         int intparam1 = Integer.parseInt(tempList.get(2));
	         int intparam2 = Integer.parseInt(tempList.get(3));
	         System.out.println("list 1(����/����) : "+ tempList.get(0));
	         System.out.println("list 2(�귣��) : "+ tempList.get(1));
	         System.out.println("list 3(�ּҰ�) : "+ tempList.get(2));
	         System.out.println("list 4(�ִ밪) : "+ tempList.get(3));
	         System.out.println("priceResult �� list size :"+ tempList.size());
	         pstmt.setString(1, tempList.get(0));
	         pstmt.setString(2, tempList.get(1));
	         pstmt.setInt(3, Math.floorDiv(intparam1,1000));
	         pstmt.setInt(4, Math.floorDiv(intparam2,1000));
	         System.out.println("�ּҰ� ��ȯ�� : "+ Math.floorDiv(intparam1,1000));
	         System.out.println("�ִ밪 ��ȯ�� : "+ Math.floorDiv(intparam2,1000));
	         rs = pstmt.executeQuery();

	         while(rs.next()){
	            int car_id = rs.getInt("CAR_ID");
	            String model_name = rs.getString("MODEL_NAME");
	            String car_pic = rs.getString("CAR_PIC");
	            int price_id = rs.getInt("PRICE_ID");
	            int brand_id = rs.getInt("BRAND_ID");
	            int cartype_id = rs.getInt("CARTYPE_ID");
	            int production_id = rs.getInt("PRODUCTION_ID");
	            String years = rs.getString("YEARS");
	            int price = rs.getInt("PRICE");
	            String fuel = rs.getString("FUEL");
	            String effiiency = rs.getString("EFFICIENCY");
	            String output = rs.getString("OUTPUT");
	            String exh = rs.getString("EXH");
	            String engine = rs.getString("ENGINE");
	            String shift = rs.getString("SHIFT");
	            String length = rs.getString("LENGTH");
	            String heigth = rs.getString("HEIGHT");
	            String width = rs.getString("WIDTH");
	            String wheelbase = rs.getString("WHEELBASE");
	            
	            CarPickDTO dto = new CarPickDTO(car_id, model_name, car_pic, price_id, brand_id, cartype_id,
	                  production_id, years, price, fuel, effiiency, output, exh,
	                  engine, shift, length, heigth, width, wheelbase);
	            result.add(dto);
	         }
	         return result;
	      }catch(SQLException s){
	         System.out.println(s);
	         return null;
	      }finally{
	         try{
	            if(rs2 != null) rs.close();
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch(SQLException s){}
	      }
	   }
	//car detail
	ArrayList<CarPickDTO> car_detail(HttpServletRequest request){
		ArrayList<CarPickDTO> car_detail = new ArrayList<CarPickDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		int car_id = 1;
		try{ //"code"��� name�� ���� ������ ���� ������ car_id�� ����
			car_id = Integer.parseInt(request.getParameter("code"));
		}catch(NumberFormatException nfe){}
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(CarPickSQL.CAR_DETAIL);
			pstmt.setInt(1, car_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String model_name = rs.getString("MODEL_NAME");
				String car_pic = rs.getString("CAR_PIC");
				int price_id = rs.getInt("PRICE_ID");
				int brand_id = rs.getInt("BRAND_ID");
				int cartype_id = rs.getInt("CARTYPE_ID");
				int production_id = rs.getInt("PRODUCTION_ID");
				String years = rs.getString("YEARS");
				int price = rs.getInt("PRICE");
				String fuel = rs.getString("FUEL");
				String effiiency = rs.getString("EFFICIENCY");
				String output = rs.getString("OUTPUT");
				String exh = rs.getString("EXH");
				String engine = rs.getString("ENGINE");
				String shift = rs.getString("SHIFT");
				String length = rs.getString("LENGTH");
				String heigth = rs.getString("HEIGHT");
				String width = rs.getString("WIDTH");
				String wheelbase = rs.getString("WHEELBASE");

				CarPickDTO dto = new CarPickDTO(car_id, model_name, car_pic, price_id, brand_id, cartype_id,
						production_id, years, price, fuel, effiiency, output, exh,
						engine, shift, length, heigth, width, wheelbase);
				car_detail.add(dto);
			}
			return car_detail;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs2 != null) rs2.close();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
//	//favor insert
//	boolean favorProductionInsert(HttpServletRequest request){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try{
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(CarPickSQL.INSERT_PRODUCTION_FAVOR);
//			pstmt.setString(1, request.getParameter("EMAIL"));
//			pstmt.setString(2, request.getParameter("review_writer"));
//			pstmt.executeUpdate();
//			return true;
//		}catch(SQLException s){
//			System.out.println(s);
//			return false;
//		}finally{
//			try{
//			    if(pstmt != null) pstmt.close();
//			    if(conn != null) conn.close();
//			}catch(SQLException s){}
//		}
//	}
//	
	//����Խ��� ����Ʈ ���
	ArrayList<CarPickDTO> reviewList(HttpServletRequest request) {
		ArrayList<CarPickDTO> reviewList = new ArrayList<CarPickDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int car_id = 1;
		try{
			car_id = Integer.parseInt(request.getParameter("code"));
		}catch(NumberFormatException e){}
	
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(CarPickSQL.REVIEW_LIST);
			pstmt.setInt(1, car_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String review_writer = rs.getString("REVIEW_WRITER");
				String review_content = rs.getString("REVIEW_CONTENT").replace(" ", "&nbsp;");
				String review_writedate = rs.getString("WRITEDATE");
				float review_grade = rs.getFloat("REVIEW_GRADE");
				
				CarPickDTO dto = new CarPickDTO(car_id, review_writer, review_content, review_writedate, review_grade);
				reviewList.add(dto);
			}
			return reviewList;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	//����Խ��� �� �߰�
	boolean reviewInsert(HttpServletRequest request){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(CarPickSQL.REVIEW_INSERT);
			pstmt.setString(1, request.getParameter("car_id"));
			pstmt.setString(2, request.getParameter("review_writer"));
			pstmt.setString(3, request.getParameter("review_content"));
			pstmt.setString(4, request.getParameter("review_grade"));//ī���� ����
			pstmt.executeUpdate();
			return true;
		}catch(SQLException s){
			System.out.println(s);
			return false;
		}finally{
			try{
			    if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	//����Խ��� ����
	boolean reviewDelete(HttpServletRequest request){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(CarPickSQL.REVIEW_DELETE);
			pstmt.setString(1, request.getParameter("car_id"));
			pstmt.setString(2, request.getParameter("review_writer"));
			pstmt.executeUpdate();
			return true;
		}catch(SQLException s){
			System.out.println(s);
			return false;
		}finally{
			try{
			    if(pstmt != null) pstmt.close();
			    if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}

	//�Ϲ� �Խ���
	ArrayList<CarPickDTO> board(){
		ArrayList<CarPickDTO> board = new ArrayList<CarPickDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
				
		try{
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CarPickSQL.BOARD);
			
			while(rs.next()){
				int board_no = rs.getInt("BONO");
				String board_subject = rs.getString("SUBJECT");
				String board_content = rs.getString("CONTENT").replace(" ", "&nbsp;").replace("&nbsp;", "\n");
				String board_writedate = rs.getString("WRITEDATE");

				CarPickDTO dto = new CarPickDTO(board_no, board_subject, board_content, board_writedate);
				board.add(dto);
			}
			return board;
		}catch(SQLException s){
			System.out.println(s);
			return null;
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException s){}
		}
	}
	
	ArrayList<CarPickDTO> detailPage(HttpServletRequest request){
	      ArrayList<CarPickDTO> result = new ArrayList<CarPickDTO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;      
	      int car_id = 1;
	      try{
	         car_id = Integer.parseInt(request.getParameter("code"));
	      }catch(NumberFormatException nfe){}
	      
	      try{
	         conn = ds.getConnection();
	         pstmt = conn.prepareStatement(CarPickSQL.CAR_DETAIL);
	         pstmt.setInt(1, car_id);
	         rs = pstmt.executeQuery();
	            while(rs.next()){
	               String model_name = rs.getString("MODEL_NAME");
	               String car_pic = rs.getString("CAR_PIC");
	               int price_id = rs.getInt("PRICE_ID");
	               int brand_id = rs.getInt("BRAND_ID");
	               int cartype_id = rs.getInt("CARTYPE_ID");
	               int production_id = rs.getInt("PRODUCTION_ID");
	               String years = rs.getString("YEARS");
	               int price = rs.getInt("PRICE");
	               String fuel = rs.getString("FUEL");
	               String effiiency = rs.getString("EFFICIENCY");
	               String output = rs.getString("OUTPUT");
	               String exh = rs.getString("EXH");
	               String engine = rs.getString("ENGINE");
	               String shift = rs.getString("SHIFT");
	               String length = rs.getString("LENGTH");
	               String heigth = rs.getString("HEIGHT");
	               String width = rs.getString("WIDTH");
	               String wheelbase = rs.getString("WHEELBASE");
	         
	               CarPickDTO dto = new CarPickDTO(car_id, model_name, car_pic, price_id, brand_id, cartype_id,
	                     production_id, years, price, fuel, effiiency, output, exh,
	                     engine, shift, length, heigth, width, wheelbase);
	               result.add(dto);
	            }
	         return result;
	      }catch(SQLException s){
	         System.out.println(s);
	         return null;
	      }finally{
	         try{
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch(SQLException s){}
	      }
	   }
	// �˻� ����Ʈ
    ArrayList<CarPickDTO> search(HttpServletRequest request) throws UnsupportedEncodingException {
       ArrayList<CarPickDTO> search = new ArrayList<CarPickDTO>();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       System.out.println("��ġDAO����");
       try {
          conn = ds.getConnection();
          pstmt = conn.prepareStatement(CarPickSQL.SEARCH);
          String text = request.getParameter("searchR");
         // if (text != null)
           //  text = new String(text.getBytes("8859_1"), "UTF-8");
          pstmt.setString(1, text);
          rs = pstmt.executeQuery();
          System.out.println("�Ķ���� ������" + request.getParameter("searchR"));
          while (rs.next()) {
             int car_id = rs.getInt("CAR_ID");
             String model_name = rs.getString("MODEL_NAME");
             String car_pic = rs.getString("CAR_PIC");
             int price_id = rs.getInt("PRICE_ID");
             int brand_id = rs.getInt("BRAND_ID");
             int cartype_id = rs.getInt("CARTYPE_ID");
             int production_id = rs.getInt("PRODUCTION_ID");
             String years = rs.getString("YEARS");
             int price = rs.getInt("PRICE");
             String fuel = rs.getString("FUEL");
             String effiiency = rs.getString("EFFICIENCY");
             String output = rs.getString("OUTPUT");
             String exh = rs.getString("EXH");
             String engine = rs.getString("ENGINE");
             String shift = rs.getString("SHIFT");
             String length = rs.getString("LENGTH");
             String heigth = rs.getString("HEIGHT");
             String width = rs.getString("WIDTH");
             String wheelbase = rs.getString("WHEELBASE");

             CarPickDTO dto = new CarPickDTO(car_id, model_name, car_pic, price_id, brand_id, cartype_id,
                   production_id, years, price, fuel, effiiency, output, exh, engine, shift, length, heigth, width,
                   wheelbase);
             search.add(dto);
          }
          return search;
       } catch (SQLException s) {
          System.out.println(s);
          return null;
       } finally {
          try {
             if (rs != null)
                rs.close();
             if (pstmt != null)
                pstmt.close();
             if (conn != null)
                conn.close();
          } catch (SQLException s) {
          }
       }
    }
}



//�˻�
//ArrayList<CarPickDTO> search(HttpServletRequest request) {
//	ArrayList<CarPickDTO> search = new ArrayList<CarPickDTO>();
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
//	try{
//		conn = ds.getConnection();
//		pstmt = conn.prepareStatement(CarPickSQL.SEARCH_FILM_TITLE);
//		pstmt.setString(1, "%" + request.getParameter("keyword") + "%");
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()){
//			String film_title = rs.getString("FILM_TITLE");
//
//			CarPickDTO dto = new CarPickDTO(film_title);
//			search.add(dto);
//		}
//		return search;
//	}catch(SQLException s){
//		System.out.println(s);
//		return null;
//	}finally{
//		try{
//			if(rs != null) rs.close();
//			if(pstmt != null) pstmt.close();
//		    if(conn != null) conn.close();
//		}catch(SQLException s){}
//	}
//}
//�˻� ���??
//int search_convert(String param) {
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
//	int film_id = 1;
//	try{
//		conn = ds.getConnection();
//		pstmt = conn.prepareStatement(CarPickSQL.SEARCH_CONVERT);
//		pstmt.setString(1, param);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()){
//			film_id = rs.getInt("FILM_ID");
//		}
//		return film_id;
//	}catch(SQLException s){
//		System.out.println(s);
//		return 1;
//	}finally{
//		try{
//			if(rs != null) rs.close();
//			if(pstmt != null) pstmt.close();
//		    if(conn != null) conn.close();
//		}catch(SQLException s){}
//	}
//}
