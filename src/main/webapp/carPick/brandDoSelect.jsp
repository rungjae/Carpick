<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../login/login_check_module.jsp"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>차종선택</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/album/">
 	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/cartype.css">
    <link rel="stylesheet" href="../css/reset.css">
    
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
        .d-flex {
		    display: flex!important;
		    margin-bottom: 0;
		}

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
            .py-lg-5 {
            	margin-top :90px;
            }
        }
  

    </style>
</head>
<script>
  function btn1(){
   const frmBtn1 = document.frm1;
   frmBtn1.setAttribute("action", "../carPick/secondSelect.jsp");
   frmBtn1.setAttribute("method", "get");
   frmBtn1.submit();
  }
</script>
<body>
<form name="frm1"></form>
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid" style="display: flex; justify-content: center;"">
       <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
        <li class="nav-item">
        	<div style="display: flex; justify-content: center; align-items: center;">
        	<a style="text-align:center" class="navbar-brand" href="/CarPick"><img src="../img/로고.png"/ width="33%"></a>
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
<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">선호하시는 브랜드를 선택해주세요</h1>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
     <div class="container">
     <form name="frm" action="select.do?m=main2" method="post">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	                <div class="col">
	                    <div class="card shadow-sm">
	                        <button name="brand" class="btn btn-outline-secondary" value="1" type="submit" onclick="btn1()"><img src="../img/brand/현대.jpg" alt="현대" width="100%" height="120" class="bd-placeholder-img card-img-top" /></button>
	                    </div>
	                </div>
                
                <div class="col">
                    <div class="card shadow-sm">
                        <button name="brand" class="btn btn-outline-secondary" value="2" type="submit" onclick="btn1()"><img src="../img/brand/기아.jpg" alt="기아" width="100%" height="120" class="bd-placeholder-img card-img-top" /></button>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <button name="brand" class="btn btn-outline-secondary" value="3" type="submit" onclick="btn1()"><img src="../img/brand/쉐보레.jpg" alt="쉐보레" width="100%" height="120" class="bd-placeholder-img card-img-top" /></button>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <button name="brand" class="btn btn-outline-secondary" value="4" type="submit" onclick="btn1()"><img src="../img/brand/쌍용.jpg" alt="쌍용" width="100%" height="120" class="bd-placeholder-img card-img-top" /></button>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <button name="brand" class="btn btn-outline-secondary" value="5" type="submit" onclick="btn1()"><img src="../img/brand/르노삼성.jpg" alt="르노삼성" width="100%" height="120" class="bd-placeholder-img card-img-top" /></button>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                    	<button name="brand" class="btn btn-outline-secondary" value="6" type="submit" onclick="btn1()"><img src="../img/brand/제네시스.jpg" alt="제네시스" width="100%" height="120" class="bd-placeholder-img card-img-top">
                    </div>
                </div>
            </div>
            </form>
        </div>
    </div>

</main>
<div class="footer">
    <h1> CARPICK </h1>
    <p>
       주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차 <br> ( 주식회사 CARPICK ) <br>
       사업자 등록번호 : 123-45-67890 <br> E-mail : CarPick@naver.com
    </p>

</div>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/form-validation.js"></script>
      
  </body>
</html>
