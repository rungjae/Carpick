package carpick.mvc.model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import carpick.mvc.model.CarPickService;
import mvc.domain.CarPickDTO;
import carpick.mvc.model.CarPickService;

public class CarPickService {
	private CarPickDAO dao;
	private static final CarPickService instance = new CarPickService();
	
	private CarPickService() {
		dao = new CarPickDAO();
	}
	public static CarPickService getInstance() {
		return instance;
	}
	//생산지, 제조사, 차종 취향 favor 
	public ArrayList<CarPickDTO> resultF(String header, String select){
		return dao.favorResult(header, select);
	}
	//금액 favor 
	public ArrayList<CarPickDTO> resultP(String header, String select_1, String select_2){
		return dao.priceResult(header, select_1, select_2);
	}
	//차 정보 표시
	public ArrayList<CarPickDTO> car_detailM(HttpServletRequest request){
		return dao.car_detail(request);
	}
	//리뷰 게시판 출력
	public ArrayList<CarPickDTO> reviewListM(HttpServletRequest request) {
		return dao.reviewList(request);
	}
	//리뷰 글쓰기
	public boolean reviewInsertM(HttpServletRequest request){
		return dao.reviewInsert(request);
	}
	//리뷰 글삭제
	public boolean reviewDeleteM(HttpServletRequest request){
		return dao.reviewDelete(request);
	}
	public ArrayList<CarPickDTO> detailPage(HttpServletRequest request){
	      return dao.detailPage(request);
	}
	//검색
    public ArrayList<CarPickDTO> searchS(HttpServletRequest request) throws UnsupportedEncodingException{
       return dao.search(request);
    }
}
