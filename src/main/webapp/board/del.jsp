<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" log.mvc.model.*, carpick.board.model.Board" %> 

<jsp:useBean id="board" class="carpick.board.model.BoardDAO" scope="application"/>
<%!
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
%>
<%   
	int seq = getSeq(request);
	if(seq != -1){
		board.del(seq);
	}
	response.sendRedirect("border.jsp");
%>