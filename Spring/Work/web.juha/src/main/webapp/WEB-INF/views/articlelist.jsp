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
    font-size: 12px;
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

#table_paging {
    width: 96%;
    margin: 0 1% 0 1%;
    padding: 0 1% 0 1%;
    text-align: center;
    background-color: #f9f9f9;
}

#table_paging>div {
    display: inline-block;
    outline: black 1px solid;
    padding: 5px;
    margin: 5px;
}

#table_paging>div:hover {
    outline: #ff9b4f 1px solid;
}

#table_btn {
    width: 96%;
    margin: 0 1% 1% 1%;
    padding: 0 1% 1% 1%;
    background-color: #f9f9f9;
}

#table_btn>* {
    display: inline-block;
    outline: black 1px solid;
    padding: 1%;
    margin: 1%;
    width: 80px;
    text-align: center;
    background-color: white;
}

#table_btn>*:hover {
    outline: #ff9b4f 1px solid;
}

.btn_write {
    float: right;
}

#table_search {
    text-align: center;
    padding: 1%;
    margin: 1%;
    background-color: #f9f9f9;
}

.btn_search {
    display: inline-block;
    outline: black 1px solid;
    width: 80px;
    text-align: center;
    background-color: white;
    padding: 1%;
    margin: 1%;
}

.input_search {
    padding: 1%;
    margin: 1%;
}

.bbs-strong {
    outline: #ff9b4f 1px solid !important;
}
</style>
<script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<script type="text/javascript">

var goList = function( page ) {
    window.location.href = "/articlelist/?board_id=0&searchWord=${searchWord}&curPage=" +page ;
};

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
        
        $('.btn_list').on({"click" : function() {
            window.location.href = '/articlelist'
                                 + '?'
                                 + 'board_id=0'; // TODO 세션에서 board_id를 가져오도록 해야함
            }
        });
        
        $('.btn_write').on({"click" : function() {
        	window.location.href = '/articlewrite';
            }
        });
        
        $('.btn_links').on({"click" : function() {
        	var page = $(this).text();
        	goList(page);
            }
        });
        
        $('.btn_next').on({"click" : function() {
            var page = ${nextLink};
            goList(page);
            }
        });
        
        $('.btn_prev').on({"click" : function() {
            var page = ${prevLink};
            goList(page);
            }
        });
        

    })
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
        
        <div id="table_search">
        <input type="text" class="input_search">
        <div class="btn_search">검색</div>
        </div>

        <div id="table_paging">
            <c:if test="${prevLink > 0 }">
                <div class="btn_prev" href="javascript:goList( ${prevLink} )">[이전]</div>
            </c:if>
            <c:forEach var="i" items="${pageLinks }" varStatus="stat">
                <c:choose>
                    <c:when test="${curPage == i}">
                        <div class="bbs-strong">${i }</div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn_links"
                            href="javascript:goList( ${i} )">${i }</div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${nextLink > 0 }">
                <div class="btn_next"
                    href="javascript:goList( ${nextLink} )">[다음]</div>
            </c:if>
        </div>

        <div id="table_btn">
            <div class="btn_list">목록</div>
            <div class="btn_write">글쓰기</div>
        </div>

    </div>
    <!-- container끝 -->

</body>
</html>
