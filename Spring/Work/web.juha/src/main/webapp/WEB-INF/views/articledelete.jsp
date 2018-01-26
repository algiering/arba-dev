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
        outline: black 1px solid;
        margin: 1%;
        padding: 1%;
        text-align: center;
    }

    #btn_container * {
        display: inline-block;
        outline: black 1px solid;
        margin: 1%;
        padding: 1%;
        width: 80px;
    }

    #btn_container *:hover {
        outline: #ff9b4f 1px solid;
    }

    #blank {
        height: 50px;
    }
</style>
<script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#btn_cancel').click(function(event) {
        	window.location.href = 'article/'
        		                 + '?'
        		                 + 'board_id=' + ${board_id}
                                 + '&'
                                 + 'article_subno=' + ${article_subno}
        });

        $('#btn_delete').click(function(event) {
        	
        	var mdata = { board_id : ${board_id}
                        , article_subno : ${article_subno}
                        , user_id : 'algiering' }
        	
        	$.ajax({
                url : '/article_delete',        // 호출되는 서버 주소
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
                                     + ${board_id};
            }).fail( function(xhr, textStatus, error ) {
                alert("connection fail");
            }).always( function(data, textStatus, xhr ) {
            });
        	
        });
    });
</script>
</head>
<body>
    <div id="container">
        <div id="blank"></div>
        <div>삭제 하시겠습니까?</div>
        <div id="blank"></div>
        <div id="btn_container">
            <div id="btn_cancel">취소</div>
            <div id="btn_delete">삭제</div>
        </div>
        <div id="blank"></div>
    </div> <!-- container끝 -->

</body>
</html>
