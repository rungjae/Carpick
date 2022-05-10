package carpick.mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carpick.mvc.model.CarPickService;
import mvc.domain.CarPickDTO;


@WebServlet("/carPick/select.do")
public class CarPickController extends HttpServlet {
   private static final long serialVersionUID = 1L;

  
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String m = request.getParameter("m");
      if(m!=null) {
         m = m.trim();
         switch (m) {
            case "firstSelect": firstSelect(request,response);break;
            case "brandDoSelect": brandDoSelect(request,response);break;
            case "brandFoSelect": brandFoSelect(request,response);break;
            case "lastPage": main3(request, response);break;
            case "main1": main1(request, response);break;
            case "main2": main2(request, response);break;
            case "main3": main3(request, response);break;
            case "detailPage": detailPage(request, response);break;
            case "search": search(request, response);break;
         }
      }else {
    	  firstSelect(request,response);
      }
   }
   private void firstSelect(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      response.sendRedirect("firstSelect.jsp");
   }
   private void brandDoSelect(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      response.sendRedirect("brandDoSelect.jsp");
   }
   private void brandFoSelect(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      response.sendRedirect("brandFoSelect.jsp");
   }
   private void lastPage(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      response.sendRedirect("lastPage.jsp");
   }
   private void main1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   System.out.println("main1 ����");
	   HttpSession session = request.getSession();
	   CarPickService service = CarPickService.getInstance();
	
	if(request.getParameter("production") != null){ //�����簡 ���õǾ�����
		String values_production = request.getParameter("production");
		System.out.println("values_production : " + values_production);
		session.setAttribute("production", values_production);
		System.out.println("���ǿϷ�");
		ArrayList<CarPickDTO> result = service.resultF("production", values_production);
		request.setAttribute("result", result);
		if(values_production.equals("1")) {
			RequestDispatcher rd = request.getRequestDispatcher("brandDoSelect.jsp"); //���������� ����Է��ʿ�
			rd.forward(request, response);
		}else
		{
			RequestDispatcher rd = request.getRequestDispatcher("brandFoSelect.jsp"); //���������� ����Է��ʿ�
			rd.forward(request, response);
		}
	}
	System.out.println("main1 ���ǹ� ��");
	}
   private void main2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   System.out.println("main2 ����");
	   HttpSession session = request.getSession();
	   CarPickService service = CarPickService.getInstance();
	
	if(request.getParameter("brand") != null){
		String values_brand= request.getParameter("brand");
		System.out.println("values_brand : " + values_brand);
		session.setAttribute("brand", values_brand);
		ArrayList<CarPickDTO> result = service.resultF("brand", values_brand);
		request.setAttribute("result", result);
	}
	System.out.println("main2 ���ǹ� ��");
	RequestDispatcher rd = request.getRequestDispatcher("secondSelect.jsp"); //���������� ����Է��ʿ�
	rd.forward(request, response);
	}
   private void main3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   System.out.println("main3 ����");
	   HttpSession session = request.getSession();
	   CarPickService service = CarPickService.getInstance();
	//�����ʿ� īŸ�Լ��ý� īŸ�Լ��ð��� ����Ǵ°Ծƴ϶� �������� ����Ǿ����..
	if(request.getParameter("cartype") != null){
		String values_cartype = request.getParameter("cartype");
		System.out.println("values_cartype : " + values_cartype);
		session.setAttribute("cartype", values_cartype);
		ArrayList<CarPickDTO> result = service.resultF("cartype", values_cartype);
		request.setAttribute("result", result);
		if(result.size() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("nullPage.jsp"); //���������� ����Է��ʿ�
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("lastPage.jsp"); //���������� ����Է��ʿ�
			rd.forward(request, response);
		}
	}else if(request.getParameterValues("price") != null){
		String[] values_price = request.getParameterValues("price");
		for(int i=0; i<values_price.length; i++) session.setAttribute("price" + i, values_price[i]);
		ArrayList<CarPickDTO> result = service.resultP("price", values_price[0], values_price[1]);
		request.setAttribute("result", result);
		if(result.size() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("nullPage.jsp"); //���������� ����Է��ʿ�
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("lastPage.jsp"); //���������� ����Է��ʿ�
			rd.forward(request, response);
		}
	}
	System.out.println("main3 ���ǹ� ��");
	}
   private void detailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	      System.out.println("main ����");
	      HttpSession session = request.getSession();
	      CarPickService service = CarPickService.getInstance();
	      ArrayList<CarPickDTO> detailPage = service.detailPage(request);
	      request.setAttribute("detailPage", detailPage);
	   System.out.println("main ���ǹ� ��");
	   RequestDispatcher rd = request.getRequestDispatcher("detailPage.jsp"); //���������� ����Է��ʿ�
	   rd.forward(request, response);
   }
   
   protected void reviewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1)Model �ڵ鸵(java)
		CarPickService service = CarPickService.getInstance();
		ArrayList<CarPickDTO> list = service.reviewListM(request);
		request.setAttribute("list", list); // list�� ��ü�� ���

		// 2)View����(jsp)
		String view = "detailPage.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
   private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html; charset=UTF-8");
       String text = request.getParameter("searchR");
     //  if (text != null)
    //      text = new String(text.getBytes("8859_1"), "UTF-8");
       System.out.println("text:" + text);
       CarPickService service = CarPickService.getInstance();
       ArrayList<CarPickDTO> result = service.searchS(request);
       request.setAttribute("result", result);
       System.out.println("search: " + result);

       if(result.size() == 0) {
           RequestDispatcher rd = request.getRequestDispatcher("nullPage.jsp"); //���������� ����Է��ʿ�
           rd.forward(request, response);
        }else {
           RequestDispatcher rd = request.getRequestDispatcher("lastPage.jsp"); //���������� ����Է��ʿ�
           rd.forward(request, response);
        }
    }
}