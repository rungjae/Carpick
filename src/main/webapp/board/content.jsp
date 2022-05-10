<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

input[type="text"]:disabled {
   background: #ccc;
}

input[type="textarea"]:disabled {
   background: #ccc;
}

.applymargin {
   display:flex;
   flex-flow: row wrap;
   justify-content:left;
   align-items:center;
   margin: 0 0 1em;
   width: 100%;
}
.ui.teal.header {
    color: lightslategrey !important;
}
.ui.teal.button, .ui.teal.buttons .button {
    background-color: lightslategrey !important;
}

</style>
</head>

<body onload="input.name.focus()">
   <div class="ui middle aligned center aligned grid">
      <div class="column">
         <h2 class="ui teal image header">해당 글 상세 보기</h2>
         <form class="ui large form" name="input" method="post"
            action="board.do?m=update">
            <div class="ui stacked segment">
               <div class="applymargin">
                  글번호 <input type="text" name="seq" id="b_title" value="${list.seq}"
                     autocomplete="off" autofocus="autofocus" disabled>
               </div>
               <div class="applymargin">
                  작성자 <input type="text" name="writer" id="b_title"
                     value="${list.writer}" autocomplete="off" autofocus="autofocus"
                     disabled>
               </div>
               <div class="applymargin">
                  이메일 <input type="text" name="email" id="b_title" value="${list.email}"
                     autocomplete="off" autofocus="autofocus" disabled>
               </div>
               <div class="applymargin">
                  제목 <input type="text" name="subject" id="b_title"
                     value="${list.subject}" autocomplete="off" autofocus="autofocus"
                     disabled>
               </div>
               <div class="applymargin">
                  내용 <div class="ui left icon input applymargin">
                     <textarea style="resize: vertical;" name="content" rows="8"
                        disabled>${list.content}</textarea>
                  </div>
               </div>
               <a class="ui fluid large teal submit button"
                  href='board.do?m=goupdate&seq=${list.seq}'>게시글 수정하러 가기</a> <br />
               <a class="ui fluid large teal submit button"
                  href='board.do?m=del&seq=${list.seq}'>게시글 삭제하기</a>
            </div>

            <div class="ui error message"></div>

         </form>

         <a href="board.do?m=list"><button
               class="ui fluid large teal submit button">뒤로가기</button></a>
      </div>
   </div>
   <!-- js 가져오기 -->
   <script src="../js/jquery3.3.1.min.js"></script>
   <script src="../js/semantic.min.js"></script>

</body>

</html>