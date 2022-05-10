<%@ page contentType="text/html;charset=utf-8"%>

<%
	boolean flag = (Boolean)request.getAttribute("flag");
%>
	<script>
	if(<%=flag%>){
		alert("입력 성공!");
	}else{
		alert("입력 실패!ㅠㅠ");
	}
	 location.href='../board/board.do'
	</script>