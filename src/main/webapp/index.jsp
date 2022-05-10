<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" class="h-100">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>CarPick</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/cover/">

   <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/cover.css" rel="stylesheet"a>
    
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
      .bg-dark{
      
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="cover.css" rel="stylesheet">
  </head>
  <body class="d-flex h-100 text-center text-white bg-dark" style="background-color: black !important;">
  <video muted autoplay loop style="margin: 0 auto;">
   <source src="video/car.mp4" type="video/mp4">
  
  </video>
    
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column" style="z-index:1; position: fixed;">
  <header class="mb-auto">
    <div>
      <h3 class="float-md-start mb-0">CarPick</h3>
      <nav class="nav nav-masthead justify-content-center float-md-end">
      </nav>
    </div>
  </header>

  <main class="px-3">
    <h1>CarPick에 오신 것을 환영합니다.</h1>
    <p class="lead">선호하시는 차량 취향에 맞게 보여드립니다.!</p>
    <p class="lead">
      <a href="carPick/select.do?m=firstSelect" class="btn btn-lg btn-secondary fw-bold border-white bg-white">시작하기</a>
    </p>
  </main>

  <footer class="mt-auto text-white-50">
  <div class="footer">
    <h1> CARPICK </h1>
    p>
       주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차 <br> ( 주식회사 CARPICK ) <br>
       사업자 등록번호 : 123-45-67890 <br> E-mail : CarPick@naver.com
    </p>

</div>
  </footer>
</div>

    
  </body>
</html>