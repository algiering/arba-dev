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
    #login_container {
        width: 100%;
        display: flex;
        justify-content: center;
        background-color: #93bcff;
        color: #474747;
    }

    #login_container>#border {
        width: 50%;
        border: black 1px solid;
        border-radius: 4px;
        margin: 30px;
        background-color: white;
    }

    #login_container>#border>#title {
        font-size: 50px;
        font-weight: bold;
    }

    #login_container>#border>#subtitle {
        font-size: 25px;
    }

    #login_container>div>div {
        width: 94%;
        margin: 20px;
        text-align: center;
    }

    #login_container>div>div>div {
        display: inline-block;
    }
    #login_container>div>div>#title {
        width: 140px;
        font-size: 25px;
        font-weight: bold;
    }
    #login_container>div>div input {
        font-size: 25px;
        padding: 0 10px;
        width: 200px;
    }
    #login_container #blank {
        height: 50px;
    }

    #login_container #btn_login {
        border: black 1px solid;
        font-size: 30px;
        font-weight: bold;
        border-radius: 4px;
        padding: 0 20px 4px 20px;
    }

    #login_container #btn_login:hover {
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

    /* footer_container */
    #footer_container {
        width: 100%;
        height: 48px;
        background-color: #93bcff;
        display: inline-flex;
        align-items: center;
        justify-content: center;
        padding-bottom: 3px;
        font-size: 14px;
        color: white;
        float: left;
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
        
        $('.btn_login').click(function(event) {
            window.location.href = '/login';
        });

        $('.btn_logout').click(function(event) {
            $.ajax({
                url : '/log_out',
                data : JSON.stringify(null), // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                type : 'get', // get, post
                timeout : 30000, // 30초
                dataType : 'json', // text, html, xml, json, jsonp, script
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다.
                }
            }).done(function(data, textStatus, xhr) {
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data == 1) {
                    window.location.href = '/boardlist';
                } else {
                    alert('정상적인 경로로 접속해주세요');
                }
            }).fail(function(xhr, textStatus, error) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always(function(data, textStatus, xhr) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
        });

        $('.btn_logo').click(function(event) {
            window.location.href = '/boardlist';
        });
        
        $('.btn_reg').click(function(event) {
            window.location.href = '/register';
        })
    });
</script>
</head>
<body>
    <div id="container">
        <div id="header">
            <%@ include file="../views/inc/header.jsp"%>
        </div>
        <div id="login_container">
            <div id="border">
                <div id="blank"></div>
                <div id="title">로그인</div>
                <div id="subtitle">환영합니다</div>
                <div id="blank"></div>
                <div>
                    <div id="title">아이디</div>
                    <div><input type="text" id="input_id" name=""></div>
                </div>
                <div>
                    <div id="title">패스워드</div>
                    <div><input type="password" id="input_password" name=""></div>
                </div>
                <div id="blank"></div>
                <div id="btn_container">
                <div id="btn_login">로그인</div>
                </div>
                <div id="blank"></div>
            </div>
        </div>
        <!-- login_container end -->
        </div>
        <!-- login_container 끝 -->
        <div id="footer">
            <%@ include file="../views/inc/footer.jsp"%>
        </div>
    </div>
    <!-- container 끝 -->
</body>
</html>
