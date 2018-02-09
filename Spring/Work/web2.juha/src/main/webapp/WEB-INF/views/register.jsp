<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    text-align: center;
    background-color: #93bcff;
}

#register_container {
    display: inline-block;
    color: #474747;
    text-align: center;
    border: #474747 1px solid;
    margin: 30px;
    border-radius: 4px;
    width: 60%;
    background-color: white;
}

#register_container>#content>#title {
    font-size: 40px;
    font-weight: bold;
}

#register_container>#content>div {
    margin: 10px;
}

#register_container>#content>div>div {
    width: 160px;
    display: inline-block;
    text-align: center;
    font-size: 20px;
    font-weight: bold;
}

#register_container>#content>div input {
    font-size: 20px;
}

#register_container>#btn_container {
    width: 100%;
}

#register_container>#btn_container>#btn_regist {
    display: inline-block;
    border: #474747 1px solid;
    border-radius: 4px;
    padding: 0 10px 3px 10px;
    width: 120px;
    font-size: 20px;
}

#register_container>#btn_container>#btn_regist:hover {
    border-color: #93bcff;
    color: #93bcff;
}

#register_container>#content #btn {
    font-size: 17px;
    width: 80px;
    padding: 0px 5px 3px 5px;
    margin-right: 50px;
    float: right;
    text-align: center;
}

#register_container>#content #btn:hover {
    border-color: #93bcff;
    color: #93bcff;
}

#register_container #blank {
    height: 50px;
}

#register_container>#content .btn_id_check {
    border: #474747 1px solid;
    border-radius: 4px;
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
</head>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

var id_check = -1;
var password_check = -1;
var email_check = -1;

$(document).ready(function() {
    $('.pass_check').change(function(event) {
    	var pass = $('.pass').val();
    	var pass_check = $('.pass_check').val();
    	if(pass != pass_check) {
    		password_check = -1;
    		alert('패스워드가 맞지 않습니다');
    	} else {
    		password_check = 1;
    	}
    });
    
    $('.pass').change(function(event) {
    	pass_check = -1;
    });
    
    $('.btn_id_check').click(function(event) {
    	
    	var user_id = $('.user_id').val();
    	
    	if (user_id == '') {
    		alert('아이디를 입력하세요');
    		return false;
    	}

        $.ajax({
            url : '/check_user_id'
            , data: JSON.stringify( user_id )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'json'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if(data == 0) {
            	alert('중복된 아이디가 없습니다');
            	id_check = 1;
            }
            else {
            	alert('중복된 아이디가 있습니다');
            	id_check = -1;
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
    });
    
    $('.user_id').change(function(event) {
    	id_check = -1;
    });
    
    $('.email').change(function(event) {
    	var email = $('.email').val();
    	if (email == '') {
    		email_check = -1;
    		alert('이메일을 입력해주세요');
    	}
    	else {
    		email_check = 1;
    	}
    });
    
    $('.btn_regist').click(function(event){
    	
    	
    	if (id_check == -1) {
    		alert('아이디 중복확인을 해주세요');
    		return false;
    	}
    	if (password_check == -1) {
    		alert('패스워드가 같은지 확인 해주세요');
    		return false;
    	}
    	if (email_check == -1) {
    		alert('이메일을 입력해주세요');
    		return false;
    	}
    	
    	if (id_check == 1 && password_check == 1 && email_check == 1) {
    		var user_id = $('.user_id').val();
    	    var user_password = $('.pass_check').val();
    	    var user_email = $('.email').val();
    	    
    	    var user = {
    	    		'user_id': user_id,
    	    		'user_password': user_password,
    	    		'user_email': user_email
    	    };
    	    
    		$.ajax({
                url : '/reg_user'
                , data: JSON.stringify( user )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
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
                	alert('가입 했습니다');
                	window.location.href = '/login';
                }
                else {
                	alert('가입에 실패 했습니다');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
    	}
    });
    
    $('.btn_login').click(function(event) {
        window.location.href = '/login';
    });
    
    $('.btn_myinfo').click(function(event) {
        window.location.href = '/edituser';
    })
    
    $('.btn_logo').click(function(event) {
        window.location.href = '/boardlist';
    });
    
    $('.btn_reg').click(function(event) {
        window.location.href = '/register';
    });
});

</script>
<body>
    <div id="header">
        <%@ include file="../views/inc/header.jsp"%>
    </div>
    <div id="container">
        <div id="register_container">
            <div id="content">
                <div id="blank"></div>
                <div id="title">회원가입</div>
                <div id="blank"></div>
                <div id="user_id">
                    <div>아이디</div>
                    <input type="text" class="user_id" name="">
                    <div id="btn" class="btn_id_check">중복확인</div>
                </div>
                <div id="user_password">
                    <div>패스워드</div>
                    <input type="password" class="pass" name="">
                    <div id="btn"></div>
                </div>
                <div id="user_password_confirm">
                    <div>패스워드 확인</div>
                    <input type="password" class="pass_check" name="">
                    <div id="btn"></div>
                </div>
                <div id="user_email">
                    <div>이메일</div>
                    <input type="text" class="email" name="">
                    <div id="btn"></div>
                </div>

            </div>
            <div id="blank"></div>
            <div class="pass_msg"></div>
            <div id="blank"></div>
            <div id="btn_container">
                <div id="btn_regist" class="btn_regist">회원가입</div>
            </div>
            <div id="blank"></div>
        </div>
        <!-- register_container end -->
    </div>
    <!-- container끝 -->
    <div id="footer">
        <%@ include file="../views/inc/footer.jsp"%>
    </div>

</body>
</html>
