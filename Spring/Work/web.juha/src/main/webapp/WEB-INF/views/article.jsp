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
        background-color: #f9f9f9;
    }

    #container>div {
        display: inline-block;
    }
    /* article_header */
    #article_header {
        width: 98%;
        margin: 1% 1% 0 1%;
        outline: black 1px solid;
        background-color: white;
        font-weight: bold;
    }
    #article_header * {
        background-color: white;
    }
    #article_header > div {
        margin: 1%;
    }
    #article_header div {
        display: inline-block;
    }
    #article_header>#row0 {
        width: 98%;
    }
    #article_header>#row1 {
        width: 98%;
    }
    #article_header>#row2 {
        width: 98%;
    }
    #article_header>#row3 {
        width: 98%;
    }
    #article_header>#row4 {
        width: 98%;
    }

    #article_header #col1 {
        width: 15%;
    }

    /* article_content */
    #article_content {
        margin: 1% 1% 0 1%;
        padding: 1%;
        outline: black 1px solid;
        width: 96%;
        background-color: white;
        line-height: 1.5em;
        font-size: 15px;
    }

    #article_content * {
        background-color: white;
    }

    /* article_footer */
    #article_footer {
        width: 98%;
        margin: 1%;
    }

    #article_footer > * {
        display: inline-block;
    }

    /* article_comment */
    #article_comment {
        margin: 1% 1% 0 1%;
        padding: 1%;
        outline: black 1px solid;
        background-color: white;
    }

    #article_comment * {
        background-color: white;
    }

    #article_comment #row0 {
        font-weight: bold;
        width: 98%;
    }

    #article_comment #comment {
        margin: 1%;
        padding: 1%;
        outline: black 1px solid;
    }

    #article_comment #comment #comment_id {
        font-weight: bold;
    }

    #article_comment #comment #comment_content {
        margin-left: 1%;
    }

    #article_comment #comment #comment_edit * {
        margin-bottom: 1%;
        display: inline-block;
        font-size: 14px;
        outline: black 1px solid;
    }

    #article_comment #recomment {
        outline: black 1px solid;
        margin: 1%;
        padding: 1%;
    }

    #article_comment #recomment #recomment_id {
        font-weight: bold;
    }

    #article_comment #recomment #recomment_content {
        margin-left: 1%;
    }


    /* btn style */
    #article_footer > div {
        outline: black 1px solid;
        padding: 1%;
        width: 50px;
        text-align: center;
        background-color: white;
        margin: 1%;
    }

    #article_footer > div:hover {
        outline: #ff9b4f 1px solid;
    }

    #btn_write {
        float: right;
    }

    #btn_delete {
        float: right;
    }

    #btn_edit {
        float: right;
    }


    #comment_edit > div:hover {
        outline: #ff9b4f 1px solid !important;

    }

</style>

<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#btn_list').click(function(event) {
            alert("click ok");
        });

        $('#btn_write').click(function(event) {
            alert("click ok");
        });

        $('#btn_delete').click(function(event) {
            alert("click ok");
        });

        $('#btn_edit').click(function(event) {
            alert("click ok");
        });

        $('#btn_recomment').click(function(event) {
            alert("click ok");
        });

        $('#btn_edit_comment').click(function(event) {
            alert("click ok");
        });

        $('#btn_delete_comment').click(function(event) {
            alert("click ok");
        });

        $('#btn_edit_recomment').click(function(event) {
            alert("click ok");
        });

        $('#btn_delete_recomment').click(function(event) {
            alert("click ok");
        });

    });
</script>
</head>
<body>
    <div id="container">
        <div id="article_header">
            <div id="row0"><div id="col1">글번호</div>&nbsp&nbsp&nbsp&nbsp<div>${article_subno}</div></div>
            <div id="row1"><div id="col1">제목</div>&nbsp&nbsp&nbsp&nbsp<div>${article_title}</div></div>
            <div id="row2"><div id="col1">작성자</div>&nbsp&nbsp&nbsp&nbsp<div>${user_id}</div></div>
            <div id="row3"><div id="col1">작성일</div>&nbsp&nbsp&nbsp&nbsp<div>${article_regdate}&nbsp&nbsp${article_regtime}</div></div>
            <div id="row4"><div id="col1">파일</div>&nbsp&nbsp&nbsp&nbsp<div>file</div></div>
        </div>
    </div>
    <!-- article_header 끝 -->

    <div id="article_content">
    ${article_content}
    </div>
    <!-- article_content 끝 -->

    <div id="article_comment">
        <div id="row0"><div>댓글</div></div>
        
                <c:forEach var="comment" items="${comment_list}">
        <div id="comment">
            <div id="comment_id">작성자</div>&nbsp&nbsp<div>
                    <div>${comment.user_id}</div>
                </div>
            <div id="comment_edit">
                <div id="btn_recomment">댓글</div>&nbsp
                <div id="btn_edit_comment">수정</div>&nbsp
                <div id="btn_delete_comment">삭제</div>
            </div>
            <div id="comment_content">${comment.comment_content}</div>
            <div id="recomment">
                <div id="recomment_id">작성자</div>&nbsp&nbsp<div></div>
                <div id="comment_edit">
                    <div id="btn_edit_recomment">수정</div>&nbsp
                    <div id="btn_delete_recomment">삭제</div>
                </div>
                <div id="recomment_content">그래서 푸릇푸릇 건강하던 아이가</div>
            </div>
        </div>
        </c:forEach>
    </div>
    <!-- article_comment 끝 -->


    <div id="article_footer">
        <div id="btn_list">목록</div>
        <div id="btn_write">글쓰기</div>
        <div id="btn_delete">삭제</div>
        <div id="btn_edit">수정</div>
    </div>
    <!-- article_footer -->

</div>
<!-- container끝 -->

</body>
</html>
