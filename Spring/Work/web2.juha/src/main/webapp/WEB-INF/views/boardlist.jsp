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

#board_container {
    border: black 1px solid;
    width: 300px;
    height: 326px;
    background-color: #f7f7f7;
    margin: 30px;
}

#board_container>#board_title {
    height: 60px;
    background-color: #93bcff;
    display: flex;
    align-items: center;
    justify-content: center;
    padding-bottom: 5px;
}

#board_container>#board_title * {
    font-size: 30px;
    font-weight: bold;
    color: white;
}

#board_container>#board_title>#board_id {
    display: none;
}

#board_container>#board_content>hr {
    border-style: dashed;
    border-color: #cecece;
    background-color: #e8e8e8;
}

#board_container>#board_content>#row {
    display: inline-flex;
    width: 100%;
    padding-bottom: 3px;
    align-items: center;
}

#board_container>#board_content>#row>#article_subno {
    display: none;
}

#board_container>#board_content>#row>#content {
    width: 60%;
    padding-left: 10px;
}

#board_container>#board_content>#row>#comment_count {
    font-size: 11px;
    margin-left: 5px;
    width: 10%;
}

#board_container>#board_content>#row>#writer {
    width: 30%;
}

#board_container>#board_content>#row:hover {
    background-color: #93bcff;
}
</style>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        $('.board_id').click(function(event) {
            var board_id = $(this).children('#board_id').text();
            window.location.href = '/articlelist'
                + '/'
                + board_id;
        });

        $('.row').click(function(event) {
            var board_id = $(this).parent().parent().children('#board_title').children('#board_id').text();
            var article_subno = $(this).children('#article_subno').text();

            window.location.href = '/articlelist'
                + '/'
                + board_id
                + '/'
                + 'article='
                + article_subno;
        })
    });
</script>
</head>
<body>
    <div id="container">
        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">mhw</div>
                <div>몬스터헌터 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_content}</div>
                        <div id="comment_count">[${article.comment_count}]</div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
    <!-- container끝 -->

</body>
</html>
