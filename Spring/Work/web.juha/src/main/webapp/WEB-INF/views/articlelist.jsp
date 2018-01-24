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

/* table */
#container * {
    background-color: white;
}

#table {
    margin: 1%;
    padding: 1%;
    width: 96%;
    outline: black 1px solid;
}

#table>* {
    display: inline-block;
    white-space: nowrap;
}

#table_header {
    width: 100%;
}

#table_header>* {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    font-weight: bold;
    height: 30px;
}

#hcol_0 {
    width: 8%;
    background-color: #e2e2e2;
}

#hcol_1 {
    width: 49%;
    background-color: #e2e2e2;
}

#hcol_2 {
    width: 8%;
    background-color: #e2e2e2;
}

#hcol_3 {
    width: 16%;
    background-color: #e2e2e2;
}

#hcol_4 {
    width: 8%;
    background-color: #e2e2e2;
}

#hcol_5 {
    width: 8%;
    background-color: #e2e2e2;
}

#table_content {
    width: 100%;
}

#table_content>* * {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 20px;
    margin: 3px 0 3px 0;
}

#col_0 {
    width: 8%;
}

#col_1 {
    width: 49%;
}

#col_2 {
    width: 8%;
}

#col_3 {
    width: 16%;
    font-size: 12px;
}

#col_4 {
    width: 8%;
}

#col_5 {
    width: 8%;
}

hr {
    width: 100%;
}
</style>
<script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        $('#table_content').children().mouseenter(function(event) {
            $(this).css('background', '#e2e2e2');
            $(this).children().css('background', '#e2e2e2');
        });
        $('#table_content').children().mouseleave(function(event) {
            $(this).css('background', 'white');
            $(this).children().css('background', 'white');
        });
        
        $('.col_1').on({
        "click" : function() {
            var article_subno = $(this).prev().text();
        	
            window.location.href = '/article/'
            	  + '?'
            	  + 'board_id=' + 0 // TODO 세션에서 board_id를 가져오도록 설정해야함
                  + '&'
            	  + 'article_subno=' + article_subno;
            	  
            }
        });  
    });
</script>
</head>
<body>
    <div id="container">
        <div id="table">
            <div id="table_header">
                <div id="hcol_0">글번호</div>
                <div id="hcol_1">제목</div>
                <div id="hcol_2">작성자</div>
                <div id="hcol_3">작성일시</div>
                <div id="hcol_4">추천</div>
                <div id="hcol_5">조회수</div>
            </div>
            <hr>
            <div id="table_content">
                <c:forEach var="article" items="${article_list}">
                    <div>
                        <div id="col_0">${article.article_subno }</div>
                        <div id="col_1" class="col_1">${article.article_title }</div>
                        <div id="col_2">${article.user_id }</div>
                        <div id="col_3">
                            <fmt:formatDate
                                value="${article.article_regdate}"
                                pattern="yyyy-MM-dd HH:mm:ss" />
                        </div>
                        <div id="col_4">${article.good }</div>
                        <div id="col_5">${article.hit }</div>
                    </div>
                </c:forEach>
            </div>

            <hr>
        </div>

    </div>
    <!-- container끝 -->

</body>
</html>
