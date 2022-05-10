<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Login</title>
    <script src="../js/trim.js"></script>
   <script language="javascript"> 
       function check(){
         var idval = f.id.value;
         idval = trim(idval);
         if(idval.length == 0){
            alert("아이디를 넣어주세요");
            f.id.value = "";
            f.id.focus();
            return false;
         }else{
            pass = checkByteLen(idval, 50);
            if(!pass){
               alert("아이디가 너무 길어요");
               f.id.focus();
               return false;
            }
         }
         
         var pwdval = f.pwd.value;
         pwdval = trim(pwdval);
         if(pwdval.length == 0){
            alert("비밀번호를 넣어주세요");
            f.pwd.value = "";
            f.pwd.focus();
            return false;
         }else{
            pass = checkByteLen(pwdval, 30);
            if(!pass){
               alert("비밀번호가 너무 길어요.");
               f.pwd.focus();
               return false;
            }
         }
   
         f.submit();
      }
   
       function checkByteLen(str, size){
           var byteLen = getByteLen(str);
         if(byteLen <= size){
            return true;
         }else{
            return false;
         }
      }
      function getByteLen(str){
         return str.replace(/[\0-\x7f]|([0-\u07ff]|(.))/g,"$&$1$2").length;
       }
      
      function enterCheck(elm){
         if(event.keyCode == 13){
            if(elm == f.id){
               f.pwd.focus();
            }else{
               check();
            }
         }
      }
   </script>

    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/modals.css" rel="stylesheet">
    <link href="../css/reset.css" rel="stylesheet">
   
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap" rel="stylesheet">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }
        .modal {
		     padding-top: 2rem!important; 
		   
		}

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body onload="document.f.id.focus()">

<div class="modal modal-signin position-static d-block bg-secondary " tabindex="-1" role="dialog" id="modalSignin">
    <div class="modal-dialog" role="document">
        <div class="modal-content rounded-5 shadow">
            <div class="modal-header p-5 pb-4 border-bottom-0">
                <!-- <h5 class="modal-title">Modal title</h5> -->
                <h2 class="fw-bold mb-0">로그인</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" href="../"></button>
            </div>

            <div class="modal-body p-5 pt-0">
   				<form name="f" action="login.do?m=check" method="post">
                    <div class="form-floating mb-3">
                        <input type="email" name="email" class="form-control rounded-4" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">이메일</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" name="pwd" class="form-control rounded-4" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">비밀번호</label>
                    </div>
                    <button class="w-100 mb-2 btn btn-lg rounded-4 btn-primary" type="submit">입력완료</button>
                </form>
                <small><a class="text-muted" href="../login/login.do?m=signup" style="text-decoration:none">회원가입 하러 가기</a></small>
            </div>
        </div>
    </div>
    <footer class="my-5 pt-5 text-muted text-center text-small">
		<div class="footer">
		    <h1> CARPICK </h1>
		    <p>
		       주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차 <br> ( 주식회사 CARPICK ) <br>
		       사업자 등록번호 : 123-45-67890 <br> E-mail : CarPick@naver.com
		    </p>
		</div>
    </footer>
</div>
</body>
</html>