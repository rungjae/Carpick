package carpick.mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carpick.board.model.*;
import carpick.mvc.model.CarPickService;
import mvc.domain.CarPickDTO;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m!=null) {
			m = m.trim();
			switch (m) {
				case "list": list(request,response);break;
				case "registerForm": registerForm(request, response);break;
				case "register": register(request, response);break;
				case "content": content(request, response);break;
				case "del": del(request, response);break;
				case "goupdate": goupdate(request, response);break;
				case "update": update(request, response);break;
			}
		}else {
			list(request,response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//model 핸들링
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);//오른쪽에 있는 list의 이름을 list로 해라 request scope사용
		
		RequestDispatcher rd = request.getRequestDispatcher("border.jsp");
		rd.forward(request, response);
	}
	private void registerForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("registerForm.jsp");
	}
	private void register(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//model 핸들링
		BoardService service = BoardService.getInstance();
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Board board = new Board(-1L, writer, email, subject, content, null);
		boolean flag = service.insertS(board);
		request.setAttribute("flag", flag);//오른쪽에 있는 list의 이름을 list로 해라 request scope사용
		
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//(1) model 핸들링(java)
		BoardService service = BoardService.getInstance();
		int seq = getSeq(request);
		Board list = service.contentS(seq);
		request.setAttribute("list", list);
	    
		//(2) View 지정(jsp)
		String view = "content.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) 
	         throws ServletException, IOException {
	      //(1)Model 핸들링 ( java )
		BoardService service = BoardService.getInstance();
	    int seq = getSeq(request);
	    service.delS(seq);
	      
	    response.sendRedirect("board.do");
	   }
	private void goupdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1) {
			BoardService service = BoardService.getInstance();
			Board goupdate = service.goupdateS(seq);
			request.setAttribute("goupdate", goupdate);//오른쪽에 있는 list의 이름을 list로 해라 request scope사용
			
			RequestDispatcher rd = request.getRequestDispatcher("goupdate.jsp");
			rd.forward(request, response);
		}	else {
			response.sendRedirect("board.do");
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1) {
			System.out.println("update 컨트롤러1");
			System.out.println("seq: "+seq);
			BoardService service = BoardService.getInstance();
			String nickname = request.getParameter("nickname");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			Board board = new Board(seq, nickname, null, subject, content, null);
			boolean flag = service.updateS(board);
			request.setAttribute("flag", flag);//오른쪽에 있는 list의 이름을 list로 해라 request scope사용
			
			System.out.println("update 컨트롤러2");
			System.out.println("nickname: "+nickname);
			System.out.println("subject: "+subject);
			System.out.println("content: "+content);
			
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
			System.out.println("update 컨트롤러3");
		}else {
			response.sendRedirect("board.do");
		}
	}
	
	
	private int getSeq(HttpServletRequest request){
        int seq = -1;
		String seqStr = request.getParameter("seq");
		if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
					seq = Integer.parseInt(seqStr); 
					return seq;
				}catch(NumberFormatException ne){
				}
			}
		}
		return seq;
	}
	
}
