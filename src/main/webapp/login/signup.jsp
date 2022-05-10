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
    <title>Product example · Bootstrap v5.1</title>

    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/form-validation.css" rel="stylesheet">
    <link href="../css/product.css" rel="stylesheet">
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
<body class="bg-light" onload="document.f.id.focus()">

<div class="container">
    <main>
        <div class="py-5 text-center">
            <h2>회원가입</h2>
            <p class="lead">선호하시는 차량 취향에 맞게 보여드립니다! <br/>이용을 원하시면 양식에 맞게 회원가입을 해주세요.</p>
        </div>

            <div class="col-md-7 col-lg-8">
                <form name="f" action="login.do?m=insert" method="post">
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="name" class="form-label">이름</label>
                            <input name="name" type="text" class="form-control" id="name" placeholder="Name" required>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="username" class="form-label">이메일</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">@</span>
                                <input name="email" type="text" class="form-control" id="email" placeholder="Email" required>
                                <div class="invalid-feedback">
                                    Your username is required.
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="pwd" class="form-label">비밀번호</label>
                            <input name="pwd" type="password" class="form-control" id="pwd" placeholder="Passward" required>
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">입력완료</button>
                </form>
            </div>
        </div>
    </main>

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

<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="js/form-validation.js"></script>
</body>
</html>