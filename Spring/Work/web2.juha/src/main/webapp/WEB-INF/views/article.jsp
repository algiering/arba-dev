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

#article_title_cline {
    display: inline-flex;
}

/* article_container */
#article_container {
    margin: 30px;
}

#article_container>#article_top_line {
    border-color: #93bcff;
}

#article_container>#content_title {
    background-color: #f7f7f7;
    padding-bottom: 10px;
}

#article_container>#content_title * {
    font-size: 16px;
}

#article_container>#content_title>#regdate>* {
    font-size: 12px;
}

#article_container>#content_title>#title, #regdate {
    display: flex;
    align-items: center;
    margin: 5px 0 5px 0;
}

#article_container>#content_title>#title, #regdate>div {
    display: inline-flex;
    justify-content: center;
}

#article_container>#content_title>#title>#title {
    width: 80px;
    text-align: center;
    font-size: 12px;
}

#article_container>#content_title>#title>#content {
    font-weight: bold;
}

#article_container>#content_title>#writer, #hit, #comment {
    display: inline-flex;
    align-items: baseline;
}

#article_container>#content_title>#writer>div {
    display: inline-flex;
    justify-content: center;
}

#article_container>#content_title>#writer>#title {
    width: 80px;
    font-size: 12px;
}

#article_container>#content_title>#hit * {
    font-size: 12px;
}

#article_container>#content_title>#hit>#title {
    width: 40px;
}

#article_container>#content_title>#comment * {
    font-size: 12px;
}

#article_container>#content_title>#comment>#title {
    width: 40px;
}

#article_container>#content_title>#regdate {
    float: right;
    margin-right: 10px;
    font-weight: bold;
}

#article_container #line {
    border-color: #f7f7f7;
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

/* article_content */
#article_content {
    padding: 0 10px 0 10px;
    margin: 20px 0 20px 0;
}

/* btn_container */
#btn_container {
    display: flex;
    justify-content: center;
}

#btn_container>div {
    display: inline-flex;
    border: #e8e8e8 1px solid;
    width: 70px;
    height: 60px;
    align-items: center;
    justify-content: center;
    padding-bottom: 3px;
    border-radius: 4px;
    background-color: #f7f7f7;
    color: #474747;
    font-size: 12px;
    margin: 0 10px 0 10px;
}

#btn_container>div * {
    text-align: center;
}

#btn_container>#btn_good>div>#vote {
    font-weight: bold;
    font-size: 16px;
    color: red;
}

#btn_container>#btn_bad>div>#vote {
    font-weight: bold;
    font-size: 16px;
    color: #474747;
}

#btn_container>div:hover {
    border-color: #93bcff;
    color: #93bcff;
}

/* comment_container */
#comment_container>div {
    display: flex;
}

#comment_container>#title>div {
    margin: 5px 10px 5px 10px;
}

#comment_container>#title>#title {
    font-size: 14px;
    font-weight: bold;
    display: flex;
    align-items: center;
}

#comment_container>#title>#content {
    font-size: 16px;
    color: #93bcff;
    display: flex;
    align-items: center;
}

#comment_container>#content {
    background-color: #e8e8e8;
}

#comment_container>#content>div {
    margin: 5px 20px 5px 20px;
}

#comment_container>#content>#writer {
    width: 80px;
}

#comment_container #comment_line {
    border-style: dashed;
    border-color: #cecece;
    background-color: #e8e8e8;
}

#comment_container>#input_form {
    background-color: #e8e8e8;
    padding-bottom: 20px;
    padding: 5px 20px 30px 20px;
}

#comment_container>#input_form>* {
    display: inline-flex;
}

#comment_container>#input_form>#input_comment {
    width: 90%;
    margin-right: 10px;
    height: 80px;
}

#comment_container>#input_form>#btn_write {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    padding-bottom: 3px;
    width: 80px;
    height: 40px;
    border: #617de2 1px solid;
    border-radius: 4px;
    background-color: #93bcff;
    font-weight: bold;
    color: white;
}

/* bottom_btn_container */
#bottom_btn_container {
    display: inline-block;
    width: 100%;
}

#bottom_btn_container>div {
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

#bottom_btn_container>#btn_list {
    float: left;
}

#bottom_btn_container>#btn_write {
    float: right;
}

#bottom_btn_container>div:hover {
    border-color: #93bcff;
    color: #93bcff;
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

$(document).ready(function() {
	$('.btn_list').click(function(event) {
		var page = 1;
		goInit(page);
    });
});

</script>
</head>
<body>
    <div id="container">
        <div id="article_container">
            <div id="board_title">
                <div style="color: #474747;">몬스터헌터</div>
                <div style="color: #93bcff;">게시판</div>
            </div>
            <!-- board_title end -->

            <hr id="article_top_line">
            <div id="content_title">
                <div id="title">
                    <div id="title">제 목</div>
                    <div id="content">${article.article_title}</div>
                </div>
                <div id="regdate">
                    <div>
                        <fmt:formatDate
                            value="${article.article_regdate}"
                            pattern="yyyy-MM-dd HH:mm:ss" />
                    </div>
                </div>
                <br>
                <div id="writer">
                    <div id="title">작성자</div>
                    <div>${article.user_id}</div>
                </div>
                <div id="article_title_cline">│</div>
                <div id="hit">
                    <div id="title">조회</div>
                    <div>${article.article_hit}</div>
                </div>
                <div id="article_title_cline">│</div>
                <div id="comment">
                    <div id="title">댓글</div>
                    <div>0</div>
                </div>
            </div>
            <!-- content_title end -->
            <div id="blank"></div>
            <div id="article_content">${article.article_content}</div>

            <div id="blank"></div>
            <div id="blank"></div>
            <div id="btn_container">
                <div id="btn_good">
                    <div>
                        추천<br>
                        <div id="vote">${article.article_good}</div>
                    </div>
                </div>
                <div id="btn_bad">
                    <div>
                        비추천<br>
                        <div id="vote">${article.article_bad}</div>
                    </div>
                </div>
            </div>
            <!-- btn_container end -->

            <div id="blank"></div>
            <hr id="line">
            <div id="comment_container">
                <div id="title">
                    <div id="title">전체 댓글 수</div>
                    <div id="content">0</div>
                </div>
                <div id="content">
                    <div id="writer">sdlkfj</div>
                    <div id="content">sgdgsdggdsgdsgsdsdgsdgsdggds</div>
                </div>
                <hr id="comment_line">
                <div id="input_form">
                    <textarea id="input_comment"></textarea>
                    <div id="btn_write">등록</div>
                </div>
            </div>
            <div id="blank"></div>
            <div id="bottom_btn_container">
                <div id="btn_list" class="btn_list">✅전체목록</div>
                <div id="btn_write">글쓰기</div>
            </div>
            <!-- article_content end -->

        </div>
        <!-- container끝 -->
</body>
</html>
</html>