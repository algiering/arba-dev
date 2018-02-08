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

#yn_container {
    font-weight: bold;
    width: 100%;
    text-align: center;
}

#yn_container>#btn_container>div {
    border-radius: 4px;
    width: 80px;
    height: 50px;
    border: #a0a0a0 1px solid;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    padding-bottom: 3px;
    font-size: 14px;
    margin: 20px;
}

#yn_container #blank {
    height: 100px;
}

#yn_container>#btn_container>div:hover {
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
	
	$('.btn_cancel').click(function(event) {
		history.back();
	})
	
	$('.btn_confirm').click(function(event) {
		
		var article_subno = '${article_subno}';
		var board_id = '${board_id}';
		
		var article = {
			'article_subno': article_subno,
			'board_id': board_id
		}
		$.ajax({
            url : '/article_delete'
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
                alert('정상적인 경로로 접속해주세요');
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
    })
    
    $('.btn_logo').click(function(event) {
        window.location.href = '/boardlist';
    });
	
});
</script>
</head>
<body>
    <div id="header">
        <%@ include file="../views/inc/header.jsp"%>
    </div>
    <div id="container">

        <div id="yn_container">
            <div id="blank"></div>
            <div id="blank"></div>
            <div>삭제 하시겠습니까?</div>
            <div id="blank"></div>
            <div id="btn_container">
                <div id="btn_cancel" class="btn_cancel">취소</div>
                <div id="btn_confirm" class="btn_confirm">확인</div>
            </div>
            <div id="blank"></div>
            <div id="blank"></div>
        </div>

    </div>
    <!-- container끝 -->

</body>
</html>