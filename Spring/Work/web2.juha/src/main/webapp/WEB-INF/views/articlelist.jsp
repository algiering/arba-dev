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

/* common */
#blank {
    height: 20px;
}

/* board_title */
#board_title {
    font-size: 25px;
    font-weight: bold;
    margin-bottom: 10px;
}

#board_title>div {
    display: inline-flex;
}

/* table */
#table {
    margin: 30px;
}

#table>#row0_top_line {
    border-color: #93bcff;
}

#table #line {
    border-color: white;
}

#table>#row0 {
    width: 100%;
    background-color: #f7f7f7;
    height: 28px;
}

#table>#row0>div {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    font-size: 12px;
    font-weight: bold;
}

#table>#row {
    margin-bottom: 1px;
}

#table>#row>div {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    font-size: 13px;
    height: 20px;
    padding-bottom: 4px;
}

#table .col0 {
    width: 10%;
}

#table .col1 {
    width: 46%;
}

#table .col2 {
    width: 10%;
}

#table .col3 {
    width: 10%;
}

#table .col4 {
    width: 10%;
}

#table .col5 {
    width: 10%;
}

#table>#row #article_no {
    font-size: 12px;
}

#table>#row #article_regdate {
    font-size: 12px;
}

#table>#row>.col1 {
    justify-content: left;
}

#row:hover {
    background-color: #93bcff;
}

/* btn_container */
#btn_container {
    display: inline-block;
    width: 100%;
}

#btn_container>div {
    border: #a0a0a0 1px solid;
    padding-bottom: 3px;
    width: 75px;
    height: 25px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    border-radius: 4px;
    font-size: 13px;
}

#btn_container>#btn_list {
    margin-left: 30px;
    float: left;
}

#btn_container>#btn_write {
    margin-right: 30px;
    float: right;
}

#btn_container>div:hover {
    border-color: #93bcff;
    color: #93bcff;
}

/* paging_container */
#paging_container {
    width: 100%;
    text-align: center;
    font-size: 14px;
    display: inline-flex;
    justify-content: center;
}

#paging_container>div {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    margin: 0 2px 0 2px;
    border: #a0a0a0 1px solid;
    height: 20px;
    padding: 0 4px 3px 4px;
}

#paging_container>#page_num {
    font-weight: bold;
    font-size: 16px;
}

#paging_container>div:hover {
    color: #93bcff;
    border-color: #93bcff;
}

/* search_container */
#search_container {
    width: 100%;
    text-align: center;
}

#search_container>div {
    display: inline-flex;
    justify-content: center;
    align-items: center;
}

#search_container>#btn_search {
    border: 1px #93bcff solid;
    width: 40px;
    color: white;
    height: 22px;
    padding-bottom: 3px;
    margin: 10px;
    background: #93bcff;
}

#search_container>div>#input_search {
    border: 4px #93bcff solid;
    width: 300px;
}
</style>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

    var goInit = function(page) {
        window.location.href = '/articlelist/'
            + '${board_id}' // TODO 세션에서 가져오도록
            + '/'
            + 'page='
            + page
    }
    
    var goPage = function(page) {
    	window.location.href = '/articlelist/'
            + '${board_id}' // TODO 세션에서 가져오도록
            + '/'
            + 'page='
            + page
            + '?'
            + 'searchWord='
            + '${searchWord}'
            + '&'
            + 'searchMode='
            + '${searchMode}' // TODO 콤보박스 추가해서 그것으로 값을 받도록
                  // 1 = 제목, 2 = 내용, 3 = 작성자, 0 = 제목,내용
    }
    
    var goSearchPage = function() {
        window.location.href = '/articlelist/'
            + '${board_id}' // TODO 세션에서 가져오도록
            + '/'
            + 'page=1'
            + '?'
            + 'searchWord='
            + $('.input_search').val()
            + '&'
            + 'searchMode='
            + '1' // TODO 콤보박스 추가해서 그것으로 값을 받도록
                  // 1 = 제목, 2 = 내용, 3 = 작성자, 0 = 제목,내용
    }

    $(document).ready(function() {
    	
    	$('.btn_page').click(function(event) {
    	    var page = $(this).text();
    	    goPage(page);
    	});
    	
    	$('.btn_first').click(function(event) {
            var page = ${totalFirstPage};
            goPage(page);
        });
        
        $('.btn_prev').click(function(event) {
            var page = ${prevLink};
            goPage(page);
        });
        
        $('.btn_next').click(function(event) {
            var page = ${nextLink};
            goPage(page);
        });
        
        $('.btn_last').click(function(event) {
            var page = ${totalLastPage};
            goPage(page);
        });
        
        $('.btn_list').click(function(event) {
            var page = ${totalFirstPage};
            goInit(page);
        });
        
        $('.btn_search').click(function(event) {
        	goSearchPage();
        });
        
        $('#row>.col1').click(function(event) {
        	var articleno = $(this).parent().children('#article_subno').children('div').text();
        	
        	window.location.href = '/articlelist/'
        	                     + '${board_id}'
        	                     + '/article='
        	                     + articleno;
        });
    	
    });
</script>
</head>
<body>
    <div id="container">
        <div id="table">

            <div id="board_title">
                <div style="color: #474747;">몬스터헌터</div>
                <div style="color: #93bcff;">게시판</div>
            </div>
            <!-- board_title끝 -->

            <hr id="row0_top_line">
            <div id="row0">
                <div id="article_no" class="col0">
                    <div>번호</div>
                </div>
                <div id="article_title" class="col1">
                    <div>제목</div>
                </div>
                <div id="article_user_id" class="col2">
                    <div>작성자</div>
                </div>
                <div id="article_regdate" class="col3">
                    <div>작성일시</div>
                </div>
                <div id="article_hit" class="col4">
                    <div>조회수</div>
                </div>
                <div id="article_good" class="col5">
                    <div>추천수</div>
                </div>
            </div>
            <hr id="line">
            <c:forEach var="article" items="${article_list}">
                <div id="row">
                    <div id="article_subno" class="col0">
                        <div>${article.article_subno}</div>
                    </div>
                    <div id="article_title" class="col1">
                        <div>${article.article_title}</div>
                    </div>
                    <div id="article_user_id" class="col2">
                        <div>${article.user_id}</div>
                    </div>
                    <div id="article_regdate" class="col3">
                        <div>
                            <fmt:formatDate
                                value="${article.article_regdate}"
                                pattern="yyyy-MM-dd" />
                        </div>
                    </div>
                    <div id="article_hit" class="col4">
                        <div>${article.article_hit}</div>
                    </div>
                    <div id="article_good" class="col5">
                        <div>${article.article_good}</div>
                    </div>
                </div>
                <hr id="line">
            </c:forEach>
        </div>
        <!-- table끝 -->

        <div id="btn_container">
            <div id="btn_list" class="btn_list">✅전체목록</div>
            <div id="btn_write" class="btn_write">글쓰기</div>
        </div>
        <!-- btn_container끝 -->

        <div id="paging_container">
            <c:if test="${curPage ne totalFirstPage}">
                <div class="btn_first">&lt&lt처음</div>
            </c:if>
            <c:if test="${prevLink > 0 }">
                <div class="btn_prev">&lt이전</div>
            </c:if>
            <c:forEach var="i" items="${pageLinks }" varStatus="stat">
                <c:choose>
                    <c:when test="${curPage == i}">
                        <div id="page_num" class="btn_page"
                            style="color: #93bcff; border-color: #93bcff;">${i}</div>
                    </c:when>
                    <c:otherwise>
                        <div id="page_num" class="btn_page">${i}</div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${nextLink > 0 }">
                <div class="btn_next">다음&gt</div>
            </c:if>
            <c:if test="${curPage ne totalLastPage}">
                <div class="btn_last">마지막&gt&gt</div>
            </c:if>

        </div>
        <!-- paging_container끝 -->

        <div id="search_container">
            <div>
                <input id="input_search" class="input_search"
                    type="text">
            </div>
            <div id="btn_search" class="btn_search">검색</div>
        </div>
        <!-- search_container끝 -->

    </div>
    <!-- container끝 -->

</body>
</html>
