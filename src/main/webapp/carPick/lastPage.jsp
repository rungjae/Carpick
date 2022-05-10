<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>CarPick</title>

<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/lastPage.css" rel="stylesheet">
<link rel="stylesheet" href="../css/reset.css">
<link href="../css/carousel.css" rel="stylesheet">


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
	<div class="container">
	<h1 style="text-align: center; margin-top: 50px; font-size: 40px;">${loginOkUser.email}님의 자동차 취향 결과입니다 'ㅅ'</h1>
	
		<c:forEach var='dto' items='${result}'>
		<div class="row row-cols-md-3 g-3">
			<div class="col" onClick='move("${dto.car_id}")'>
				<div class="card shadow-sm">
					<img
						src="${pageContext.request.contextPath}/carPick/img/car/${dto.car_pic}"
						class="bd-placeholder-img card-img-top" width="100%"
						height="225" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder: Thumbnail"
						preserveAspectRatio="xMidYMid slice" focusable="false">
					<rect width="100%" height="100%"></rect>
					<text x="50%" y="50%" dy=".3em"></text>
					</svg>
					<div class="card-body">
						<p class="card-text"></hr>모델명 : ${dto.model_name}</p>
						<div class="d-flex justify-content-between align-items-center">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>


	</main>
	<footer class="py-3">
		<div class="footer" style="margin-top: 70px;">
			<h1>CARPICK</h1>
			<p>
	            주소 : 서울시 금천구 가산동 426-5 월드메르디앙 2차 <br> ( 주식회사 CARPICK ) <br>
	            사업자 등록번호 : 123-45-67890 <br> E-mail : CarPick@naver.com
	        </p>
		</div>
	</footer>

	<!-- JS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/scrollreveal/scrollreveal.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/creative.min.js"></script>

	<!-- Kakao SDK -->
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

	<script>
		function move(code) { //이밎 클릭시 상세정보로 이동
			location.href = 'select.do?m=detailPage&code=' + code;
		}

		$("#search").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "<c:url value='bitcinema.do?page=search'/>",
					type : 'post',
					dataType : 'json',
					data : "&keyword=" + $("#search").val(),
					success : function(data) {
						var result = data;
						response(result);
					},
					error : function(data) {
						alert("검색 중 문제가 발생하였습니다.");
					}
				});
			},
			autoFocus : false,
			minLength : 2
		});

		function search(keyword) {
			var regex = /\s/;
			if (keyword == null || keyword == "" || keyword == " ") {
				alert('검색어를 입력해 주세요!');
				return;
			} else {
				location.href = 'bitcinema.do?page=search_convert&title='
						+ keyword;
			}
		}
	</script>
</body>

</html>