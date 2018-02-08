<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="header_container">
    <div id="logo" class="btn_logo">LOGO</div>
    <div id="btn_container">
        <c:choose>
            <c:when test="${login_check}">
                <div class="btn_logout">로그아웃</div>
                <div class="btn_myinfo">내 정보</div>
            </c:when>
            <c:otherwise>
                <div class="btn_login">로그인</div>
                <div class="btn_reg">회원가입</div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
