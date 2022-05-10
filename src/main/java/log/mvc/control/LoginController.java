package log.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carpick.mvc.model.CarPickService;
import log.mvc.model.LoginService;
import log.mvc.model.Member;

import static log.mvc.model.LoginConst.*;

@WebServlet("/login/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
				case "form": form(request, response); break;
				case "signup": signup(request, response); break;
				case "check": check(request, response);break;
				case "insert": insert(request, response);break;
				case "logout": logout(request, response); break;
			}
		}else {
			response.sendRedirect("../");
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "login.jsp";
		response.sendRedirect(view);
	}
	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "signup.jsp";
		response.sendRedirect(view);
	}
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		//��ȿ�� �˻�(Ŭ���̾�Ʈ�� View:js, ������ Controller:java)
		System.out.println("email: "+email+", pwd: "+pwd);
		
		LoginService service = LoginService.getInstance();
		int result = service.check(email,pwd);
		System.out.println("result: "+result);
		
		if(result == YES_ID_PWD) {
			Member m = service.getMemberS(email);
			HttpSession session = request.getSession();
			session.setAttribute("loginOkUser", m);
		}
		request.setAttribute("result", result);
		
		String view  ="msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
	         throws ServletException, IOException {
	      //(1)Model �ڵ鸵 ( java )
	       String email = request.getParameter("email");
	       String name = request.getParameter("name");
	       String pwd = request.getParameter("pwd");
	       System.out.println("email: "+ email + ", name: " + name + ", pwd: " + pwd);
	       
	       LoginService service = LoginService.getInstance();
	       int result = service.signupcheck(email);
	       System.out.println("result: " + result);
	        
	       if(result != EX_ID) { 
	          Member dto = new Member(email, name, pwd);
	          boolean flag = service.insertS(dto);
	          System.out.println("flag: " + flag);
	       }
	       request.setAttribute("result", result);
	       
	      //(2)View ���� ( jsp )e
	       String view = "insert.jsp";
	       RequestDispatcher rd = request.getRequestDispatcher(view);
	       rd.forward(request, response);
	   }
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.removeAttribute("loginOkUser"); //Ư�� ���� ����
		session.invalidate(); //��ü���ǻ���
		
		response.sendRedirect("../"); //index�������� �̵�
	}
}
