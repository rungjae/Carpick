<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>   
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>CarPick</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">    
    <link href="../css/product.css" rel="stylesheet">
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
        #fontline {
       	  display: flex;
		}
    </style>
</head>
<body>

<header class="site-header sticky-top py-1">
    <nav class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="navbar-brand" href="/CarPick"><img src="../img/로고.png"/ width="33%"></a>
        
        <c:choose>
			<c:when test="${empty loginOkUser}">
				<a class="py-2" href="../login/login.do?m=form">로그인</a>
				<a class="py-2 d-none d-md-inline-block" href="../login/login.do?m=signup">회원가입</a>
			</c:when>
			<c:otherwise>
				<div>
				<font id="fontline" class="py-2" style="color:green; texg-align:center">${loginOkUser.email} 님 환영합니다</font>
				</div>
				<a class="py-2" href="../login/login.do?m=logout">로그아웃</a>
				 <form class="d-flex" action="select.do?m=search" method="post">
	                  <input class="form-control me-2" name="searchR" type="text"
	                     placeholder="브랜드검색" aria-label="Search">
	                  <button class="btn btn-outline-success" type="submit">Search</button>
        		 </form>
			</c:otherwise>
		</c:choose>
    </nav>
</header>
<form name="frm" action="select.do?m=main1" method="post">
	<div>
	    <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3" style="width: 450px; height: 750px">
	        <div class="bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
	            <div class="my-3 py-3">
	                <h2 class="display-5">국산차</h2>
	                <p class="lead">국산차를 보고싶으시다면 아래 버튼을 눌러주세요.</p>
	                <button name="production" id="production" value="1"  class="btn btn-outline-secondary" type="submit">선택</button>
	            </div>
	            <div class="bg-light shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"><img src="../img/domestic.png" class="top-padding" alt="국산차" width="90%" height="280px"/></div>
	        </div>
	        <div class="bg-light me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden" style="width: 450px; height: 750px">
	            <div class="my-3 p-3">
	                <h2 class="display-5">외제차</h2>
	                <p class="lead">외제차를 보고싶으시다면 아래 버튼을 눌러주세요.</p>
	                <button name="production" id="production" value="2"  class="btn btn-outline-secondary" type="submit">선택</button>
	            </div>
	            <div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"><img src="../img/foriegn.png" class="top-padding" alt="외제차" width="90%" height="280px"/></div>
	        </div>
	    </div>
	</div>
</form>
<footer>
      <div class="footer" style="margin-top: 70px;">
         <h1>CARPICK</h1>
         <p>
            주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차 <br> ( 주식회사 CARPICK ) <br>
            사업자 등록번호 : 123-45-67890 <br> E-mail : CarPick@naver.com
         </p>
      </div>
   </footer>
</body>
</html>