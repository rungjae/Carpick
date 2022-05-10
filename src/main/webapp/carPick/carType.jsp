<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Flipster Demo</title>
    <meta name="description" content="">
   <meta name="viewport" content="width=550, initial-scale=1">
   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="../dist/jquery.flipster.min.css">
    <link rel="stylesheet" href="../css/reset.css">
    <link href="../css/carousel.css" rel="stylesheet">
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/cartype.css">
    
    <!-- Fonts -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link
		href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
		rel="stylesheet">
	<link
		href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap"
		rel="stylesheet" />
	<link
		href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap"
		rel="stylesheet">
   
   <script src="../dist/jquery.flipster.min.js"></script>
   <style>
   	 img {
   	 	width : 400px;
   	 	height : 400px;
   	 }
   	 .logo {
		width : 33% !important;
		height : 30% !important;
   	 }
   </style>
</head>
<body>

   <script>
   function setCursor(str, str2){
      str.style.cursor = str2;
   }
   $( document ).ready(function(){
      var options      = {
         start: 0,
         fadeIn: 400,
         loop: true,
         buttonPrev: 'Previous',
         buttonNext: 'Next',
         style: 'carousel',
         spacing: -0.6,
         nav: false,
         buttons:   true,
      };
      $('.my-flipster').flipster(options);
   });

   </script>
	<header>
	    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		    <div class="container-fluid" style="display: flex; justify-content: center;"">
		       <div class="collapse navbar-collapse" id="navbarCollapse">
		        <ul class="navbar-nav me-auto mb-2 mb-md-0">
		        <li class="nav-item">
		        	<div style="display: flex; justify-content: center; align-items: center;">
		        	<a style="text-align:center" class="navbar-brand" href="/CarPick"><img class="logo" src="../img/로고.png"/ width="33%"></a>
		        	</div>
		        </li>
	          &nbsp;
	          <li class="nav-item">
	             <c:choose>
	         <c:when test="${empty loginOkUser}">
	         	&nbsp;
	            <a class="py-2" href="../login/login.do?m=form">로그인</a>
	            &nbsp;&nbsp;
	            <a class="py-2 d-none d-md-inline-block" href="../login/login.do?m=signup">회원가입</a>
	         </c:when>
	         <c:otherwise>
	            <div>
	            <font id="fontline" class="py-2 nav-link active" style="color:green; texg-align:center">${loginOkUser.email} 님 환영합니다</font>
	            </div>
	         </li>
	         <li class="nav-item"><a class="py-2 nav-link active" href="../login/login.do?m=logout">로그아웃</a>
	            </c:otherwise>
	            </c:choose>
	           </li>
	          <li class="nav-item">
	           <a class="nav-link" href="../board/board.do?m=list">커뮤니티 게시판 보러가기</a>
	         </li>
	        </ul>
	        <form class="d-flex" action="select.do?m=search" method="post">
                 <input class="form-control me-2" name="searchR" type="text"
                    placeholder="브랜드검색" aria-label="Search">
                 <button class="btn btn-outline-success" type="submit">Search</button>
      		 </form>
	      </div>
	    </div>
	  </nav>
	</header>
   <form name="frm" action="select.do?m=main3" method="post">
   <div style="/*width:600px;*/">
      <div class="my-flipster">
         <ul>
            <li data-flip-title="Red">
               <button id="carTypebtn" name="cartype" value="1" class="img1" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype1.jpg"></button>
            </li>
            <li data-flip-title="Razzmatazz" data-flip-category="Purples">
               <button id="carTypebtn" name="cartype" value="2" class="img2" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype2.jpg"></button>
             </li>
            <li data-flip-title="Deep Lilac" data-flip-category="Purples">
               <button id="carTypebtn" name="cartype" value="3" class="img3" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype3.jpg"></button>
            </li>
            <li data-flip-title="Daisy Bush" data-flip-category="Purples">
               <button id="carTypebtn" name="cartype" value="4" class="img4" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype4.jpg"></button>
            </li>
            <li data-flip-title="Cerulean Blue" data-flip-category="Blues">
               <button id="carTypebtn" name="cartype" value="5" class="img5" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype5.jpg"></button>
            </li>
            <li data-flip-title="Dodger Blue" data-flip-category="Blues">
               <button id="carTypebtn" name="cartype" value="6" class="img6" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype6.jpg"></button>
            </li>
            <li data-flip-title="Dodger Blue" data-flip-category="Blues">
               <button id="carTypebtn" name="cartype" value="7" class="img7" onmouseover="setCursor(this,'pointer')"><img src="../img/cartype7.jpg"></button>
            </li>
         </ul>
      </div>
   </div>
</form>
<div class="footer">
    <h1> CARPICK </h1>
    <p>
       주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차 <br> ( 주식회사 CARPICK ) <br>
       사업자 등록번호 : 123-45-67890 <br> E-mail : CarPick@naver.com
    </p>

</div>

</body>
</html>