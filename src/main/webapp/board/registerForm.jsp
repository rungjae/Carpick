<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 작성하기</title>
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
        .ui.teal.button, .ui.teal.buttons .button {
    		background-color: lightslategrey !important;
    		color: #fff !important;}
    		
    		.ui.teal.header {
    color: lightslategrey !important;
}
    </style>
    <script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력 하셔야 합니다. ");
				 return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
</head>

<body onload="input.name.focus()">
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <h2 class="ui teal image header">
                게시글 작성하기
            </h2>
            <form class="ui large form" name="input" method="post" action="board.do?m=register">
                <div class="ui stacked segment">
                    <div class="field">
                        <input type="text" name="writer" id="b_title" placeholder="작성자" autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field">
                        <input type="text" name="email" id="b_title" placeholder="이메일" autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field">
                        <input type="text" name="subject" id="b_title" placeholder="글제목" autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <textarea style="resize: vertical;" name="content" placeholder="게시글 내용" rows="8"></textarea>
                        </div>
                    </div>
                    <input type="button" class="ui button" value="게시글 작성하기" onclick="check()">
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
