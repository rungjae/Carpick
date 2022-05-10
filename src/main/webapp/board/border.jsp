<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap"
	rel="stylesheet">
<link href="../css/boardfont.css" rel="stylesheet">


<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
<!-- css 가져오기 -->
<link rel="stylesheet" type="text/css" href="../css/semantic.min.css">
<style type="text/css">
body {
	background-color: #DADADA;
}

body>.grid {
	height: 100%;
}

.image {
	margin-top: -100px;
}

.column {
	max-width: 1000px;
}

.view_btn {
	cursor: pointer;
}

.t_button {
	width: 50% !important;
}

.ui.teal.button, .ui.teal.buttons .button {
	background-color: lightslategrey !important;
}

.t_button {
	float: right !important;
	width: 48% !important;
}
.ui.stacked.segment {
    padding-bottom: 4em !important;
}
</style>
</head>

<body>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<h2 class="ui teal image header" style="color : lightslategrey !important">게시판 페이지</h2>
			<div class="ui large form">
				<div class="ui stacked segment">
					<table class="ui celled table">
						<thead>
							<tr>
								<th>글번호</th>
								<th>작성자</th>
								<th>이메일</th>
								<th>글제목</th>
								<th>등록일</th>
							</tr>
						</thead>
						<c:if test="${empty list}">
							<tr>
								<td colspan="5" style="text-align: center">데이터가 하나도 없네요</td>
							</tr>
						</c:if>

						<c:forEach items="${list}" var="board">
							<tr>
								<td align='center'>${board.seq}</td>
								<td align='center'>${board.writer}</td>
								<td align='center'>${board.email}</td>
								<td align='center'><a
									href='board.do?m=content&seq=${board.seq}'>${board.subject}</a>
								</td>
								<td align='center'>${board.rdate}</td>
							</tr>
						</c:forEach>
					</table>
					<div
						style="padding-left: 30%; justify-content: center; align-items: center;">
						<div>
							<a href="../carPick/select.do"><button
									class="ui fluid large teal submit button t_button"
									style="float: left !important; margin: 0 0.25em 0 -281px !important;">차량 등록 페이지로 돌아가기</button></a> <a
								href="board.do?m=registerForm"><button
									class="ui fluid large teal submit button t_button">
									게시글 작성하기</button></a>

						</div>
					</div>
				</div>
				<div class="ui error message"></div>
			</div>
		</div>
	</div>

	<div class="ui modal" id='view_modal'>
		<i class="close">x</i>
		<div class="header" id="b_title"></div>
		<div class="content">
			<div class="description">
				<p style="text-align: right" id="b_review"></p>
				<div id='b_content'></div>
			</div>
		</div>
		<div class="actions">
			<div class="ui black deny button">닫기</div>
		</div>
	</div>

	<!-- js 가져오기 -->
	<script src="../js/jquery3.3.1.min.js"></script>
	<script src="../js/semantic.min.js"></script>
</body>

</html>