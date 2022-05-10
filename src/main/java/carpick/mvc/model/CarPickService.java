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
	//������, ������, ���� ���� favor 
	public ArrayList<CarPickDTO> resultF(String header, String select){
		return dao.favorResult(header, select);
	}
	//�ݾ� favor 
	public ArrayList<CarPickDTO> resultP(String header, String select_1, String select_2){
		return dao.priceResult(header, select_1, select_2);
	}
	//�� ���� ǥ��
	public ArrayList<CarPickDTO> car_detailM(HttpServletRequest request){
		return dao.car_detail(request);
	}
	//���� �Խ��� ���
	public ArrayList<CarPickDTO> reviewListM(HttpServletRequest request) {
		return dao.reviewList(request);
	}
	//���� �۾���
	public boolean reviewInsertM(HttpServletRequest request){
		return dao.reviewInsert(request);
	}
	//���� �ۻ���
	public boolean reviewDeleteM(HttpServletRequest request){
		return dao.reviewDelete(request);
	}
	public ArrayList<CarPickDTO> detailPage(HttpServletRequest request){
	      return dao.detailPage(request);
	}
	//�˻�
    public ArrayList<CarPickDTO> searchS(HttpServletRequest request) throws UnsupportedEncodingException{
       return dao.search(request);
    }
}
