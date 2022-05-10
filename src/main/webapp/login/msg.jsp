<%@ page contentType="text/html; charset=UTF-8" import="log.mvc.model.LoginConst"%>
<script>
    if(${result} == <%=LoginConst.NO_ID%>){
    	alert("그런 이메일을 가진 회원이 없어요");
    	location.href="login.do?m=form";
    }else if(${result} == <%=LoginConst.NO_PWD%>){
    	alert("비밀번호가 맞지 않아요");
    	location.href="login.do?m=form";
    }else{
    	location.href="../carPick/select.do?m=firstSelect";
    }
</script>