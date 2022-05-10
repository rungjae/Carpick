package carpick.mvc.model;

public class CarPickSQL {
	// Signin & Signup
	final static String EMAIL_CHECK = "select EMAIL from MEMBER";
	final static String PW_CHECK = "select PWD from MEMBER where EMAIL = ?";
	final static String SIGNUP = "insert into MEMBER values(?, ?, ?, SYSDATE, 0)";
	
	// Select
	final static String PRODUCTION_LIST = "select * from PRODUCTION";
	final static String BRAND_LIST = "select * from BRAND";
	final static String CAR_LIST = "select * from CARTYPE";
	final static String PRICE_LIST = "select * from PRICE";

	// Main
//	final static String SELECT_PRODUCTION = "select * from CAR where PRODUCTION_ID = ?";
//	final static String SELECT_BRAND = "select * from CAR where BRAND_ID = ?";
	final static String SELECT_CARTYPE_ALL = "select * from CAR where PRODUCTION_ID=? and BRAND_ID=? and CARTYPE_ID=?";
	final static String SELECT_PRICE_ALL = "select * from CAR where PRODUCTION_ID=? and BRAND_ID=? and PRICE_ID between ? and ?";
//	select * from CAR where PRODUCTION_ID=? AND BRAND_ID=? AND CARTYPE_ID=?
//	select * from CAR where PRODUCTION_ID=? AND BRAND_ID=? AND CARTYPE_ID=? and PRICE_ID between ? and ?
	
	//Favor insert
	final static String INSERT_PRODUCTION_FAVOR = "insert into PRODUCTION_FAVOR (EMAIL, PRONO_1) values(?,?)";
	final static String INSERT_BRAND_FAVOR = "insert into BRAND_FAVOR (EMAIL, BRNO_1) values(?,?)";
	final static String INSERT_CAR_FAVOR = "insert into CAR_FAVOR (EMAIL, CARSNO_1) values(?,?)";
	final static String INSERT_PRICE_FAVOR = "insert into PRICE_FAVOR (EMAIL, PRONO_1, PRINO_2) values(?,?,?)";

	// Car detail
	final static String CAR_DETAIL = "select * from CAR where CAR_ID = ?";
//	final static String FILM_DETAIL_DIRECTOR = "select * from DIRECTOR where DIRECTOR_NAME = ?";
//	final static String FILM_DETAIL_ACTOR = "select * from ACTOR where ACTOR_NAME = ?";
	
	// search
   final static String SEARCH = "select * from car natural join brand where BRAND_NAME like '%' || ? || '%'";
   final static String SEARCH2 = "select * from car a ,brand b where a.BRAND_ID = b.BRAND_ID and BRAND_NAME like '%?%'";

	// Review List
	final static String REVIEW_LIST = "select * from CAR_REVIEW where CAR_ID = ? order by WRITEDATE desc";
	final static String REVIEW_INSERT = "insert into CAR_REVIEW values(?, ?, ?, SYSDATE, ?)";
	final static String REVIEW_DELETE = "delete CAR_REVIEW where CAR_ID = ? and EMAIL = ?";

	// AVG BIT Grade
	final static String AVG_GRADE_BIT = "select AVG(REVIEW_GRADE) FILM_GRADE_BIT from FILM_REVIEW where FILM_ID = ?";
	// Board
	final static String BOARD = "select * from BOARD";
}
