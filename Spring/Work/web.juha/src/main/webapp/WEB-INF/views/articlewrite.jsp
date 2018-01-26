<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

* {
    font-family: 'Nanum Gothic', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f9f9f9;
}

#container {
    background-color: white;
}

#form {
    margin: 1%;
    padding: 1%;
    width: 96%;
    outline: black 1px solid;
}

form>div>* {
    display: inline-block;
}

hr {
    margin: 1% 0 1% 0;
}

#title {
    font-weight: bold;
    margin-right: 1%;
}

#input_title {
    width: 85%;
    height: 25px;
    padding: 0 5px 0 5px;
}

#input_content {
    width: 100%;
    min-height: 300px;
}

#btn {
    margin: 1%;
}

#btn>div {
    display: inline-block;
    float: right;
    margin: 1%;
    padding: 1%;
    outline: black 1px solid;
    width: 80px;
    text-align: center;
}

#btn>div:hover {
    outline: #ff9b4f 1px solid;
}
</style>

<script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	
    	$('.btn_write').click(function(event) {

    		var article_title = $('#input_title').val();
    		var article_content = $('#input_content').val();
    		var user_id = 'algiering';  // TODO 세션에서 가져오게
    		var board_id = ${board_id}; // TODO 세션에서 가져오게
    		
            var mdata = { article_title: article_title
            		   , article_content: article_content
            		   , user_id: user_id
            		   , board_id: board_id}
    		
                $.ajax({
                    url : '/article_write',        // 호출되는 서버 주소
                    data: mdata,        // 서버로 보내는 클라이언트 데이터. 사용하는 경우에는 { data1:'test1', data2:'test2' }
                    type: 'post',       // get, post
                    timeout: 30000,    // 30초, 최대 대기시간
                    dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                    beforeSend : function() {
                    }
                }).done( function(data, textStatus, xhr ){
                    window.location.href = '/articlelist'
                                         + '?'
                                         + 'board_id='
                                         + board_id;
                }).fail( function(xhr, textStatus, error ) {
                    alert("connection fail");
                }).always( function(data, textStatus, xhr ) {
                });
        })
        
        $('.btn_cancel').click(function(event) {
        	window.location.href = '/articlelist'
                + '?'
                + 'board_id=0' // TODO 세션에서 board_id를 가져오도록 해야함
        })
    	
    });
</script>
</head>
<body>
    <div id="container">
        <div id="form">
            <form>
                <div>
                    <div id="title">제목</div>
                    <input type="text" id="input_title">
                </div>
                <hr>
                <div>
                    <textarea id="input_content"></textarea>
                </div>
                <div></div>
            </form>
        </div>

        <div id="btn">
            <div class="btn_write">글쓰기</div>
            <div class="btn_cancel">취소</div>
        </div>
    </div>
    <!-- container끝 -->

</body>
</html>
