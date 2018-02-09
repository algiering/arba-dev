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
    display: inline-block;
    float: left;
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
    white-space:nowrap;
    overflow:hidden;
    text-overflow: ellipsis;
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
        });
        
        $('.btn_myinfo').click(function(event) {
        window.location.href = '/edituser';
    })
    });
</script>
</head>
<body>
    <div id="header">
        <%@ include file="../views/inc/header.jsp"%>
    </div>
    <div id="container">
        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">electro</div>
                <div>전자기기 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${electro_article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_title}</div>
                        <div id="comment_count">
                            <c:if
                                test="${article.comment_count ne null and article.comment_count ne 0}">[${article.comment_count}] </c:if>
                        </div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">potable</div>
                <div>휴대기기 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${potable_article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_title}</div>
                        <div id="comment_count">
                            <c:if
                                test="${article.comment_count ne null and article.comment_count ne 0}">[${article.comment_count}] </c:if>
                        </div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">game</div>
                <div>게임 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${game_article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_title}</div>
                        <div id="comment_count">
                            <c:if
                                test="${article.comment_count ne null and article.comment_count ne 0}">[${article.comment_count}] </c:if>
                        </div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">program</div>
                <div>프로그래밍 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${program_article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_title}</div>
                        <div id="comment_count">
                            <c:if
                                test="${article.comment_count ne null and article.comment_count ne 0}">[${article.comment_count}] </c:if>
                        </div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">hobby</div>
                <div>취미 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${hobby_article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_title}</div>
                        <div id="comment_count">
                            <c:if
                                test="${article.comment_count ne null and article.comment_count ne 0}">[${article.comment_count}] </c:if>
                        </div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        

        <div id="board_container">
            <div id="board_title" class="board_id">
                <div id="board_id">qna</div>
                <div>문의사항 게시판</div>
            </div>
            <div id="board_content">
                <c:forEach var="article" items="${qna_article_list}">
                    <hr>
                    <div id="row" class="row">
                        <div id="article_subno">${article.article_subno}</div>
                        <div id="content">${article.article_title}</div>
                        <div id="comment_count">
                            <c:if
                                test="${article.comment_count ne null and article.comment_count ne 0}">[${article.comment_count}] </c:if>
                        </div>
                        <div id="writer">${article.user_id}</div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
    <!-- container끝 -->
    <div id="footer">
            <%@ include file="../views/inc/footer.jsp"%>
        </div>

</body>
</html>
