<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html data-brackets-id="1" lang="en">
<head data-brackets-id="2">
<meta data-brackets-id="3" charset="utf-8">
<meta data-brackets-id="4" http-equiv="X-UA-Compatible"
   content="IE=edge,chrome=1">
<meta data-brackets-id="5" name="viewport"
   content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=0">
<title data-brackets-id="6">Ion.RangeSlider - Basic demo |
   IonDen.com</title>
<meta data-brackets-id="7" name="title"
   content="Ion.RangeSlider - Basic demo | IonDen.com">
<meta data-brackets-id="8" name="og:title"
   content="Ion.RangeSlider - Basic demo | IonDen.com">
<meta data-brackets-id="9" name="description"
   content="Learn how to use Ion.RangeSlider on several practical demos">
<meta data-brackets-id="10" name="og:description"
   content="Learn how to use Ion.RangeSlider on several practical demos">
<meta data-brackets-id="11" name="keywords"
   content="range slider, diapason, interval, price range, price slider">
<meta data-brackets-id="12" name="author"
   content="Denis Ineshin - IonDen.com">
<link data-brackets-id="13" rel="stylesheet" href="../css/sdsss.css">
<link data-brackets-id="13" rel="stylesheet" href="../css/reset.css">
<link data-brackets-id="13" rel="stylesheet" href="../css/scroll.css">
<link data-brackets-id="14" rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css">
   <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap" rel="stylesheet">
   
   <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/product.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/reset.css">
    <link href="../css/carousel.css" rel="stylesheet">
<!--jQuery-->
<script data-brackets-id="16" async=""
   src="https://mc.yandex.ru/metrika/tag.js"></script>
<script data-brackets-id="17" async=""
   src="//www.google-analytics.com/analytics.js"></script>
<script data-brackets-id="18"
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!--Plugin JavaScript file-->
<script data-brackets-id="19"
   src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>
  <style>
     .fixed-top {
       --bs-bg-opacity: 1;
       background-color: rgba(var(--bs-dark-rgb),var(--bs-bg-opacity))!important;
   }
   .irs-from, .irs-to, .irs-single {
       background: linear-gradient(to bottom, black 0%, black 100%) !important;
   }
   .irs--big .irs-bar {
       border: 1px solid black !important;
       background: linear-gradient(to bottom, #ffffff 0%, gray 30%, gray 50%) !important;
   }
  </style>
  
</head>

<body data-brackets-id="20">
   <header>
     <nav class="navbar navbar-expand-md navbar-dark fixed-top">
       <div class="container-fluid">
         <div style="display: flex; justify-content: center; align-items: center;">
        	<a style="text-align:center" class="navbar-brand" href="/CarPick"><img src="../img/로고.png"/ width="33%"></a>
        	</div>
         <div class="collapse navbar-collapse" id="navbarCollapse">
           <ul class="navbar-nav me-auto mb-2 mb-md-0">
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
   <div data-brackets-id="21" class="content">
      <div data-brackets-id="22" class="content__wrapper">
         <div data-brackets-id="23" class="content__container">
            <div data-brackets-id="24" class="page-start"></div>
            <div data-brackets-id="25" class="content__item">
               <div data-brackets-id="26" class="content__flow">
                  <div data-brackets-id="27" class="content__flow-main">
                     <div data-brackets-id="28" class="demo">
                        <!--DEMO: 3-->
                        <div class="demo__item">
                           <p class="scroll-p">원하시는 가격대를 정해주세요</p>
                           <form name="frm" action="select.do?m=main3" method="post">
                           <div class="demo__body">
                              <span class="irs-handle to type_last" style="left: 75.5195%;"><i></i><i></i><i></i></span></span>
                              <input id="demo_4" type="text" name="" value=""
                                 class="irs-hidden-input input-hidden" tabindex="-1" readonly=""></input>
                                 <input name="price" id="input_from" type="hidden" name="" value="0"
                                 tabindex="-1" readonly=""></input>
                                 <input name="price" id="input_to" type="hidden" name="" value="5000"
                                 tabindex="-1" readonly=""></input>
                                 <div style="display: flex; justify-content: center;">
                                 </div>
                                 &nbsp;
                                 <div style="display: flex; justify-content: center;">
                                 <button type="submit" class="btn btn-dark">검색하기</button>
                                 </div>
                           </div>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <footer data-brackets-id="80" class="footer">
               <div data-brackets-id="81" class="footer">
                  <h1 data-brackets-id="82">CARPICK</h1>
                  <p data-brackets-id="83">
                     주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차<br data-brackets-id="84">
                     ( 주식회사 CARPICK ) <br data-brackets-id="85"> 사업자 등록번호 :
                     123-45-67890 <br data-brackets-id="86"> E-mail :
                     CarPick@naver.com
                  </p>
               </div>
            </footer>
         </div>

      </div>
   </div>


   <script data-brackets-id="87" type="text/javascript">
      var $d4 = $("#demo_4");
      /* var $d4-1 = $("#demo_4-1"); */

      $d4.ionRangeSlider({
         skin : "big",
         type : "double",
         step : 1000,
         min : 0,
         max : 10000,
         from : 0,
         to : 5000
      });

      $d4.on("change", function() {
         var $inp = $(this);
         var v = $inp.prop("value"); // input value in format FROM;TO
         var from = $inp.data("from"); // input data-from attribute
         var to = $inp.data("to"); // input data-to attribute

         console.log(v, from, to); // all values
         $('#input_from').val(from);
         $('#input_to').val(to);
      });
      
   </script>

   <div class="__brackets-ld-highlight"
      style="left: 166px; top: 17px; width: 1204px; height: 278.6px; z-index: 2000000; margin: 0px; padding: 0px; position: absolute; pointer-events: none; box-sizing: content-box; border-width: 0px; border-style: none; border-color: rgba(21, 165, 255, 0.85); transform: none; transform-origin: 602px 139.3px; background-color: rgba(0, 162, 255, 0); opacity: 0.6; transition-property: opacity, background-color, transform; transition-duration: 300ms, 2.3s;">
      <div
         style="background-color: rgba(21, 165, 255, 0.58); height: 0px; width: 1204px; left: 0px; top: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="background-color: rgba(21, 165, 255, 0.58); width: 0px; height: 278.6px; top: 0px; right: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="background-color: rgba(21, 165, 255, 0.58); height: 0px; width: 1204px; left: 0px; bottom: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="background-color: rgba(21, 165, 255, 0.58); width: 0px; height: 278.6px; top: 0px; left: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="border-width: 1px; border-style: dashed; border-color: rgba(0, 162, 255, 0.5); height: 0px; width: 1204px; left: 0px; top: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="border-width: 1px; border-style: dashed; border-color: rgba(0, 162, 255, 0.5); width: 0px; height: 278.6px; top: 0px; right: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="border-width: 1px; border-style: dashed; border-color: rgba(0, 162, 255, 0.5); height: 0px; width: 1204px; left: 0px; bottom: 0px; position: absolute; display: none; transform: none;"></div>
      <div
         style="border-width: 1px; border-style: dashed; border-color: rgba(0, 162, 255, 0.5); width: 0px; height: 278.6px; top: 0px; left: 0px; position: absolute; display: none; transform: none;">
      </div>
   </div>
</body>
</html>