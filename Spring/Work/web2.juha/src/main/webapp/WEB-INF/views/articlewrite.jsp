<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true"%>
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
}

#container {
    margin: 30px;
}

#board_title {
    font-size: 25px;
    font-weight: bold;
    margin-bottom: 10px;
}

#board_title>div {
    display: inline-flex;
}

/* write_container */
#write_container>div {
    margin: 5px 10px 5px 10px;
}

#write_container>#header_line {
    border-color: #93bcff;
    margin-bottom: 20px;
}

/* title */
#title {
    display: inline-flex;
    width: 98%;
}

#title>#title {
    font-size: 14px;
    font-weight: bold;
    width: 90px;
    min-width: 90px;
    align-items: center;
}

#title>#input {
    width: 70%;
}

#title>#input>#input_title {
    width: 80%;
}

#file {
    display: inline-flex;
    width: 98%;
}

#file>#title {
    font-size: 14px;
    font-weight: bold;
    width: 90px;
    min-width: 90px;
    align-items: center;
}

#file>#input_file {
    width: 70%;
}

#write_container>#content {
    margin: 10px 0 10px 0;
}

#write_container>#content>#input_content {
    width: 100%;
    height: 400px;
}

/* btn_container */
#write_container>#btn_container {
    display: inline-block;
    width: 98%;
}

#write_container>#btn_container>div {
    border: #a0a0a0 1px solid;
    padding-bottom: 3px;
    width: 75px;
    height: 25px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    border-radius: 4px;
    font-size: 13px;
}

#write_container>#btn_container>#btn_list {
    float: left;
}

#write_container>#btn_container>#btn_cancel {
    float: right;
    margin-right: 10px;
}

#write_container>#btn_container>#btn_write {
    float: right;
}

#write_container>#btn_container>div:hover {
    border-color: #93bcff;
    color: #93bcff;
}

/* header_container */
#header_container {
    width: 100%;
    height: 52px;
    background-color: #93bcff;
}

#header_container>#btn_container {
    display: inline-block;
    float: right;
}

#header_container>#btn_container>div {
    display: inline-flex;
    width: 80px;
    justify-content: center;
    align-items: center;
    padding-bottom: 3px;
    color: white;
    border: white 1px solid;
    border-radius: 4px;
    height: 25px;
    margin: 10px 10px 10px 0;
}

#header_container>#btn_container>div:hover {
    background-color: white;
    color: #93bcff;
}

#header_container>#logo {
    display: inline-flex;
    width: 80px;
    height: 38px;
    padding-bottom: 2px;
    justify-content: center;
    align-items: center;
    border: white 1px solid;
    margin: 5px;
    color: white;
    border-radius: 4px;
}

#header_container>#logo:hover {
    background-color: white;
    color: #93bcff;
}
</style>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('.btn_list').click(function(event) {
        	window.location.href = "/articlelist"
        	                     + "/"
        	                     + "${board_id}";
        });
        /* $('.btn_write').click(function(event) {
        	var article_title = $('.input_title').val();
        	if (article_title == '') {
        		alert('제목을 입력하세요');
        		return false;
        	}
        	var article_content = $('.input_content').val();
        	article_content = article_content.replace(/\n/gi, '<br>');
        	var board_id = '${board_id}';
        	
        	var article = { 'article_title': article_title,
                    'article_content': article_content,
                    'board_id': board_id }
        	
        	$.ajax({
        	    url : '/article_write'
        	    , data: JSON.stringify( article )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
        	    , type: 'post'       // get, post
        	    , timeout: 30000    // 30초
        	    , dataType: 'json'  // text, html, xml, json, jsonp, script
        	    , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
        	    , beforeSend : function() {
        	        // 통신이 시작되기 전에 이 함수를 타게 된다.
        	    }
        	}).done( function(data, textStatus, xhr ){
        	    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
        	    if (data == 1) {
        	    window.location.href = '/articlelist'
        	                         + '/'
        	                         + '${board_id}';
        	    }
        	    else {
        	    	alert('알 수 없는 오류입니다');
        	    }
        	                         
        	}).fail( function(xhr, textStatus, error ) {
        	    // 통신이 실패했을 때 이 함수를 타게 된다.
        	    alert('정상적인 경로로 접속해주세요');
        	}).always( function(data, textStatus, xhr ) {
        	    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        	});
        }); */
        
        $('.btn_write').click(function(event) {
        	var input_title = $('.input_title').val()
        	input_title = input_title.replace(/\n/gi, '<br>');
        	var input_content = $('.input_content').val();
        	input_content = input_content.replace(/\n/gi, '<br>');
        	
        	$('.input_title').val(input_title);
        	$('.input_content').val(input_content);
        	
        	$('.article_form').submit();
        });
        $('.btn_cancel').click(function(event) {
        	history.back();
        });
        
        $('.btn_login').click(function(event) {
            window.location.href = '/login';
        });
        
        $('.btn_logout').click(function(event) {
            $.ajax({
                url : '/log_out'
                , data: JSON.stringify( null )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                , type: 'get'       // get, post
                , timeout: 30000    // 30초
                , dataType: 'json'  // text, html, xml, json, jsonp, script
                , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
                , beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data == 1) { 
                window.location.href = '/boardlist';
                }
                else {
                    alert('정상적인 경로로 접속해주세요');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
        });
        
        $('.btn_logo').click(function(event) {
            window.location.href = '/boardlist';
        });
        
        $('.input_title').val('${article_title}');
        $('.input_content').val('${article_content}');
        
    });
</script>
</head>
<body>
    <div id="header">
        <%@ include file="../views/inc/header.jsp"%>
    </div>
    <div id="container">
        <form class="article_form" action="/article_write" method="post" enctype="multipart/form-data">
            <div id="board_title">
                <div style="color: #474747;">${board_title}</div>
                &nbsp
                <div style="color: #93bcff;">게시판</div>
            </div>
            <div id="write_container">
                <hr id="header_line">
                <div id="title">
                <input type="text" name="board_id" value="${board_id}" style="display: none;">
                    <div id="title">제목</div>
                    <div id="input">
                        <input type="text" id="input_title"
                            class="input_title" name="article_title">
                    </div>
                </div>
                <div id="file">
                    <div id="title">파일 업로드</div>
                    <div>
                        <input type="file" id="input_file" name="upload">
                    </div>
                </div>
                <div id="content">
                    <textarea id="input_content" class="input_content" name="article_content"></textarea>
                </div>

                <div id="btn_container">
                    <div id="btn_list" class="btn_list">✅전체목록</div>
                    <div id="btn_write" class="btn_write">글쓰기</div>
                    <div id="btn_cancel" class="btn_cancel">취소</div>
                </div>
            </div>
        </form>
    </div>
    <!-- container끝 -->

</body>
</html>