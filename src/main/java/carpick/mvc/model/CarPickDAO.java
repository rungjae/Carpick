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
	ArrayList<String> tempList = new ArrayList<String>(); //사용자 선택값 임시 저장
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
	      System.out.println("favorResult 시작 list size :"+ tempList.size());
	      try{
	         conn = ds.getConnection();
	         
	         if(param0.equals("production")) { //선택 주제가 생산지 일시
	            tempList.clear();//첫시작시 초기화
	            if(tempList.size() >= 1){// 현재선택값이 비어있지않으면
	               tempList.set(0, param1);//1번째 값을 수정
	            }else {
	               tempList.add(param1); //생산지 선택값 저장
	            }
	         }else if(param0.equals("brand")) { // 선택 주제가 브랜드 일시
	            if(tempList.size() >= 2){// 현재선택값이 비어있지않으면
	               tempList.set(1, param1);//2번째 값을 수정
	            }else {
	               tempList.add(param1);
	            }
	         }else if(param0.equals("cartype")) { // 선택 주제가 차종일시
	            if(tempList.size() >= 3){// 현재선택값이 비어있지않으면
	               if(tempList.size() >= 4) {
	                  tempList.remove(2);
	                  tempList.remove(3);
	                  tempList.add(param1);
	               }else {
	                  tempList.set(2, param1); //3번째 값을 수정
	               }
	            }else {
	               tempList.add(param1);
	            }
	            pstmt = conn.prepareStatement(CarPickSQL.SELECT_CARTYPE_ALL);
	            System.out.println("list 1(국산/외제선택값) : "+ tempList.get(0));
	            System.out.println("list 2(브랜드선택값) : "+ tempList.get(1));
	            System.out.println("list 3(차종값) : "+ tempList.get(2));
	            System.out.println("favorResult 끝 list size :"+ tempList.size());
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
	   ArrayList<CarPickDTO> priceResult(String param0, String param1, String param2){ //취향 리스트 담는 역할
	      ArrayList<CarPickDTO> result = new ArrayList<CarPickDTO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      ResultSet rs2 = null;
	      System.out.println("priceResult 시작 list size :"+ tempList.size());
	      try{
	         conn = ds.getConnection();
	         
	         if(param0.equals("price")) { //가격을 선택 했을시
	            if(tempList.size() >= 3){// 현재선택값이 비어있지않으면
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
	         System.out.println("list 1(국산/외제) : "+ tempList.get(0));
	         System.out.println("list 2(브랜드) : "+ tempList.get(1));
	         System.out.println("list 3(최소값) : "+ tempList.get(2));
	         System.out.println("list 4(최대값) : "+ tempList.get(3));
	         System.out.println("priceResult 끝 list size :"+ tempList.size());
	         pstmt.setString(1, tempList.get(0));
	         pstmt.setString(2, tempList.get(1));
	         pstmt.setInt(3, Math.floorDiv(intparam1,1000));
	         pstmt.setInt(4, Math.floorDiv(intparam2,1000));
	         System.out.println("최소값 변환값 : "+ Math.floorDiv(intparam1,1000));
	         System.out.println("최대값 변환값 : "+ Math.floorDiv(intparam2,1000));
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
		try{ //"code"라는 name을 가진 곳에서 값을 가져와 car_id에 저장
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
	//리뷰게시판 리스트 출력
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
	//리뷰게시판 글 추가
	boolean reviewInsert(HttpServletRequest request){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(CarPickSQL.REVIEW_INSERT);
			pstmt.setString(1, request.getParameter("car_id"));
			pstmt.setString(2, request.getParameter("review_writer"));
			pstmt.setString(3, request.getParameter("review_content"));
			pstmt.setString(4, request.getParameter("review_grade"));//카리뷰 평점
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
	//리뷰게시판 삭제
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

	//일반 게시판
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
	// 검색 리스트
    ArrayList<CarPickDTO> search(HttpServletRequest request) throws UnsupportedEncodingException {
       ArrayList<CarPickDTO> search = new ArrayList<CarPickDTO>();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       System.out.println("서치DAO시작");
       try {
          conn = ds.getConnection();
          pstmt = conn.prepareStatement(CarPickSQL.SEARCH);
          String text = request.getParameter("searchR");
         // if (text != null)
           //  text = new String(text.getBytes("8859_1"), "UTF-8");
          pstmt.setString(1, text);
          rs = pstmt.executeQuery();
          System.out.println("파라미터 벨류값" + request.getParameter("searchR"));
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



//검색
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
//검색 기능??
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
