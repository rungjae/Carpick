<%@ page contentType="text/html;charset=utf-8" import="carpick.board.model.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>해당 글 상세 보기</title>
    <!-- css 가져오기 -->
    <link rel="stylesheet" type="text/css" href="../css/semantic.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gowun+Dodum&family=Nanum+Gothic+Coding:wght@400;700&display=swap" rel="stylesheet">
	<link href="../css/boardfont.css" rel="stylesheet">
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
            max-width: 450px;
        }
        .applymargin {
		   display:flex;
		   flex-flow: row wrap;
		   justify-content:left;
		   align-items:center;
		   margin: 0 0 1em;
		   width: 100%;
		}
		.field{
			display:flex;
		   flex-flow: row wrap;
		   justify-content:left;
		}
		.ui.teal.button, .ui.teal.buttons .button {
    		background-color: lightslategrey !important;
    		color: #fff !important;}
    		
    		.ui.teal.header {
    color: lightslategrey !important;
}
    </style>
</head>

<body onload='javascript:document.f.email.focus();'>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <h2 class="ui teal image header">
                해당 글 수정하기
            </h2>
            <form class="ui large form" name="f" method="post" action="board.do?m=update&seq=${goupdate.seq}">
            <input type='hidden' name='seq' value='${goupdate.seq}'>
			<input type='hidden' name='writer' value='${goupdate.writer}'>
                <div class="ui stacked segment">
                <div class="field">
                    글번호 <input type="text" name="seq" id="b_title" value="${goupdate.seq}" autocomplete="off" autofocus="autofocus" disabled>
                    </div>
                    <div class="applymargin">
                        작성자<input type="text" name="nickname" id="b_title" value="${goupdate.writer}" autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field">
                       이메일 <input type="text" name="email" id="b_title" value="${goupdate.email}" autocomplete="off" autofocus="autofocus" disabled>
                    </div>
                    <div class="applymargin">
                       제목 <input type="text" name="subject" id="b_title" value="${goupdate.subject}" autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field">
                        내용<div class="ui left icon input">
                          <textarea style="resize: vertical;" name="content" rows="8">${goupdate.content}</textarea>
                        </div>
                    </div>
                    <input class="ui fluid large teal submit button" type="submit" value="게시글 수정하기">
                </div>

                <div class="ui error message"></div>

            </form>

            <a href="board.do?m=list"><button class="ui fluid large teal submit button">뒤로가기</button></a>
        </div>
    </div>
    <!-- js 가져오기 -->
    <script src="../js/jquery3.3.1.min.js"></script>
    <script src="../js/semantic.min.js"></script>

</body>

</html>