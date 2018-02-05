<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

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
        position: relative;
    }


    /* login_background */
    #login_background {
        width: 100%;
        height: 100%;
        min-width: 1000px;
    }


    /* login_content */
    #login_content {
        background-color: black;
        position: absolute;
        top: 13%;
        left: 29%;
        width: 40%;
        height: 450px;
        opacity: 0.7;
        display: inline-block;
        text-align: center;
        min-width: 400px;
        border-radius: 10px;
    }

    #login_content>#login_title {
        color: white;
        font-size: 40px;
        font-weight: bold;
    }

    #login_content>#title {
        color: white;
        display: inline-block;
        width: 20%;
        margin: 5px 10px 5px 0px;
        font-size: 20px;
        font-weight: bold;
    }

    #login_content>input {
        height: 35px;
        display: inline-block;
        width: 50%;
        margin-right: 10px;
        padding: 0 10px 0 10px;
        margin: 5px 10px 5px 0px;
        font-size: 20px;
        font-weight: bold;
        border-radius: 5px;
    }

    #login_content>#blank {
        height: 7%;
    }

    #login_content>#space {
        width: 30%;
    }

    #login_content>#btn_login {
        display: inline-block;
        text-align: center;

    }

    #login_content>#btn_login>div {
        color: white;
        margin: 10px;
        padding-top: 7px;
        border: white 1px solid;
        width: 160px;
        height: 30px;
        border-radius: 5px;
    }

    #login_content>#btn_login>div:hover {
        border-color: #ffa81c;
    }

</style>
<script type="text/javascript" src="resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	    	
        $('#btn_login').click(function(event) {
            if ($('#input_id').val()=='') {
                alert("ID를 입력하세요");
            }
            else if ($('#input_password').val()=='') {
                alert("비밀번호를 입력하세요");
            }
            else {
            	
            	var mdata = {
            			user_id: $('#input_id').val(),
                        user_password: $('#input_password').val()
            	}
            	
            	$.ajax({
                    url : '/login'
                    , data: JSON.stringify( mdata )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                    , type: 'post'       // get, post
                    , timeout: 30000    // 30초
                    , dataType: 'json'  // text, html, xml, json, jsonp, script
                    , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
                    , beforeSend : function() {
                        // 통신이 시작되기 전에 이 함수를 타게 된다.
                    }
                }).done( function(data, textStatus, xhr ){
                	if(data == 1) {
                		window.location.href = '/boardlist'
                	}
                	else {
                		alert('아이디나 비밀번호가 틀립니다');
                	}
                }).fail( function(xhr, textStatus, error ) {
                    alert("connetion failed");
                }).always( function(data, textStatus, xhr ) {
                    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
                });
            }
        });
    });
</script>
</head>
<body>
    <div id="container">
        <div id="login_container">
            <img id="login_background" src="resources/images/background_login.jpg">
            <div id="login_content">
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="login_title">로그인</div>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="title">아이디</div><input type="text" id="input_id" name="" placeholder="아이디"><div id="space"></div>
                <div id="title">비밀번호</div><input type="password" id="input_password" name="" placeholder="비밀번호"><div id="space"></div>
                <div id="blank"></div>
                <div id="btn_login"><div>로그인</div></div>
            </div>
            <!-- login_content 끝 -->
        </div>
        <!-- login_container 끝 -->
    </div>
    <!-- container 끝 -->
</body>
</html>
