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

#login {
    margin: 1% 1% 0 1%;
    padding: 1%;
    outline: black 1px solid;
}

/* form */
form>* {
    display: inline-block;
    height: 30px;
}

form>div {
    width: 20%;
    text-align: right;
    font-size: 20px;
}

form>input {
    padding: 1%;
    font-size: 17px;
}

#blank {
    width: 18%;
}

#div_blank {
    height: 150px;
    width: 100%;
}

#msg {
    text-align: center;
    height: 30px;
    width: 100%;
    color: red;
    font-weight: bold;
}
/* botton */
.btn {
    outline: black 1px solid;
    width: 10%;
    display: inline-block;
    float: right;
    margin: 1%;
    padding: 1%;
    text-align: center;
}

.btn:hover {
    outline: #ff9b4f 1px solid;
}
</style>
<script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        $('#btn_login').click(function(event) {
        	$('#login_form').submit();
        });
        $('#btn_cancel').click(function(event) {
        });
    });
</script>
</head>
<body>
    <div id="container">
        <div id="login">
            <div id="div_blank"></div>
            <form id="login_form" name="login_form" action="login_ok" method="post">
                <div id="blank"></div>
                <div>아이디</div>
                &nbsp&nbsp <input type="text" name="user_id"> 
                <br>
                <br>
                <div id="blank"></div>
                <div>비밀번호</div>
                &nbsp&nbsp <input type="password" name="user_password">
                <br>
                <br>
                <br>
                <br>

                <div id="msg">
                    <c:if test="${not empty msg}">
                        ${msg}
                    </c:if>
                </div>
            </form>
            <!-- form끝 -->
            <div id="div_blank"></div>
        </div>
        <!-- login끝  -->
        <div id="btn_login" class="btn">로그인</div>
        <div id="btn_cancel" class="btn">취소</div>
    </div>
    <!-- container끝 -->

</body>
</html>