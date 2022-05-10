<%@ page contentType="text/html;charset=utf-8" import="log.mvc.model.LoginConst"%>

<script>
    if(${result} == <%=LoginConst.NO_ID%>){
       alert("회원가입 성공");
    }else if(${result} == <%=LoginConst.EX_ID%>){
       alert("이미 존재하는 이메일 입니다");
       location.href="../login/login.do?m=signup";
    }
    location.href="../login/login.do?m=form";
 </script>