<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Carousel Template · Bootstrap v5.1</title>

	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/carousel.css" rel="stylesheet">
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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
  <body>
    
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


    <div class="row featurette">
      <div class="col-md-7 order-md-2">
        <h2 class="featurette-heading">${detailPage.get(0).model_name}<span class="text-muted"></span></h2><hr/> 
        <p class="lead">연식 : ${detailPage.get(0).years}</br>
        가격 : ${detailPage.get(0).price} (단위: 만원)<br/>
        연료 : ${detailPage.get(0).fuel}<br/>
        연비 : ${detailPage.get(0).effiiency}<br/>
        출력 : ${detailPage.get(0).output}<br/>
        배기 : ${detailPage.get(0).exh}<br/>
        엔진 : ${detailPage.get(0).engine}<br/>
        변속 : ${detailPage.get(0).shift}<br/>
        전장 : ${detailPage.get(0).length}<br/>
        전고 : ${detailPage.get(0).heigth}<br/>
        전폭 : ${detailPage.get(0).width}<br/>
        축거 : ${detailPage.get(0).wheelbase}<br/>
	  </p>      
      </div>
      <div class="col-md-5 order-md-1">		
      <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" src="${pageContext.request.contextPath}/carPick/img/car/${detailPage.get(0).car_pic}" width="600px" height="600px" style="padding-top:60px">

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
  </body>
</html>
