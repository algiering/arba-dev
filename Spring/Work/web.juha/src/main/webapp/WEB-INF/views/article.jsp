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

#article_header>div {
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

#article_header>#row5 {
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

#article_footer>* {
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
#article_footer {
    width:96%;
}

#article_footer>div {
    outline: black 1px solid;
    padding: 1%;
    width: 50px;
    text-align: center;
    background-color: white;
    margin: 1%;
}

#article_footer>div:hover {
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

#comment_edit>div:hover {
    outline: #ff9b4f 1px solid !important;
}

#article_vote {
    width: 96%;
    margin: 1%;
    padding: 1%;
    height: 30px;
}

#article_vote > div {
    background: white;
    outline: black 1px solid;
    display: inline-block;
    padding: 1%;
    width: 80px;
    text-align: center;
    float: right;
    margin: 0 1% 0 1%;
}

#article_vote>div:hover {
    outline: #ff9b4f 1px solid !important;
}

</style>

<script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<script type="text/javascript">

    $(document).ready(function() {
        $('.btn_list').on({"click" : function() {
        	window.location.href = '/articlelist'
                + '?'
                + 'board_id=' + ${board_id} // TODO 세션에서 board_id를 가져오도록 해야함
            }
        });

        $('.btn_write').on({"click" : function() {
            alert("click ok");
            }
        });

        $('.btn_delete').on({"click" : function() {
        	
        	var article_subno = $(".article_no").text();
        	
        	window.location.href = '/articledelete'
        	                     + '?'
        	                     + 'board_id=' + ${board_id}
                                 + '&'
                                 + 'article_subno=' + article_subno
                                 + '&'
                                 + 'user_id=' + 'algiering'
            }
        });

        $('.btn_edit').on({"click" : function() {
        	
        	var article_subno = $(".article_no").text();
        	var user_id = $(".user_id").text();
        	
        	window.location.href = '/articleedit'
        	                     + '?'
        	                     + 'board_id=' + ${board_id}
        	                     + '&'
                                 + 'article_subno=' + article_subno
        	                     + '&'
        	                     + 'user_id=' + user_id;
        	
            }
        });

        $('.btn_recomment').on({"click" : function() {
            alert("click ok");
            }
        });

        $('.btn_edit_comment').on({"click" : function() {
            alert("click ok");
            }
        });

        $('.btn_delete_comment').on({"click" : function() {
            alert("click ok");
            }
        });

        $('.btn_edit_recomment').on({"click" : function() {
            alert("click ok");
            }
        });

        $('.btn_delete_recomment').on({"click" : function() {
            alert("click ok");
            }
        });
        
        $('#btn_good').click(function(event) {

        	var article_subno = $(".article_no").text();
            var article = { article_subno : article_subno, clicked: 0, board_id: 0 } // TODO board_id는 세션에서 가져오도록 해야함
            
        	$.ajax({
        	    url : '/article_vote',        // 호출되는 서버 주소
        	    data: article,        // 서버로 보내는 클라이언트 데이터. 사용하는 경우에는 { data1:'test1', data2:'test2' }
        	    type: 'post',       // get, post
        	    timeout: 30000,    // 30초, 최대 대기시간
        	    dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
        	    beforeSend : function() {
        	    }
        	}).done( function(data, textStatus, xhr ){
        		$('#btn_good').text('추천 : ' + data) // TODO 세션에서 해당 아이디가 추천을 최대 한번까지만 가능하도록 해야함
        	}).fail( function(xhr, textStatus, error ) {
        		alert("connection fail");
        	}).always( function(data, textStatus, xhr ) {
        	});
        })
        
        $('#btn_bad').click(function(event) {
        	var article_subno = $(".article_no").text();
            var article = { article_subno : article_subno, clicked: 1, board_id: 0 } // TODO board_id는 세션에서 가져오도록 해야함
            
            $.ajax({
                url : '/article_vote',        // 호출되는 서버 주소
                data: article,        // 서버로 보내는 클라이언트 데이터. 사용하는 경우에는 { data1:'test1', data2:'test2' }
                type: 'post',       // get, post
                timeout: 30000,    // 30초, 최대 대기시간
                dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                beforeSend : function() {
                }
            }).done( function(data, textStatus, xhr ){
            	$('#btn_bad').text('비추천 : ' + data) // TODO 세션에서 해당 아이디가 비추천을 최대 한번까지만 가능하도록 해야함
            }).fail( function(xhr, textStatus, error ) {
            	alert("connection fail");
            }).always( function(data, textStatus, xhr ) {
            });
        })

    });
</script>
</head>
<body>
    <div id="container">
        <div id="article_header">
            <div id="row0">
                <div id="col1">글번호</div>
                &nbsp&nbsp&nbsp&nbsp
                <div class="article_no">${article_subno}</div>
            </div>
            <div id="row1">
                <div id="col1">제목</div>
                &nbsp&nbsp&nbsp&nbsp
                <div>${article_title}</div>
            </div>
            <div id="row2">
                <div id="col1">작성자</div>
                &nbsp&nbsp&nbsp&nbsp
                <div class="user_id">${user_id}</div>
            </div>
            <div id="row3">
                <div id="col1">작성일</div>
                &nbsp&nbsp&nbsp&nbsp
                <div>${article_regdate}&nbsp&nbsp${article_regtime}</div>
            </div>
            <div id="row4">
                <div id="col1">조회수</div>
                &nbsp&nbsp&nbsp&nbsp
                <div>${hit}</div>
            </div>
            <div id="row5">
                <div id="col1">파일</div>
                &nbsp&nbsp&nbsp&nbsp
                <div>file</div>
            </div>
        </div>
    </div>
    <!-- article_header 끝 -->

    <div id="article_content">${article_content}</div>
    <!-- article_content 끝 -->

    <div id="article_comment">
        <div id="row0">
            <div>댓글</div>
        </div>

        <c:forEach var="comment" items="${comment_list}">
            <div id="comment">
                <div>작성자</div>&nbsp&nbsp<div><div id="comment_id">${comment.user_id}</div>
                </div>
                <div id="comment_edit">
                    <div id="btn_recomment" class="btn_recomment">댓글</div>
                    &nbsp
                    <div id="btn_edit_comment" class="btn_edit_comment">수정</div>
                    &nbsp
                    <div id="btn_delete_comment"
                        class="btn_delete_comment">삭제</div>
                </div>
                <div id="comment_content">${comment.comment_content}</div>
                <c:forEach var="recomment" items="${recomment_list}">
                    <c:if
                        test="${recomment.comment_no eq comment.comment_no}">
                        <div id="recomment">
                            <div id="recomment_id">${recomment.user_id}</div>
                            &nbsp&nbsp
                            <div></div>
                            <div id="comment_edit">
                                <div id="btn_edit_recomment"
                                    class="btn_edit_recomment">수정</div>
                                &nbsp
                                <div id="btn_delete_recomment"
                                    class="btn_delete_recomment">삭제</div>
                            </div>
                            <div id="recomment_content">${recomment.recomment_content }</div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
    <!-- article_comment 끝 -->

    <div id="article_vote">
        <div id="btn_good">추천 : ${good}</div> 
        <div id="btn_bad">비추천 : ${bad}</div>
    </div>

    <div id="article_footer">
        <div id="btn_list" class="btn_list">목록</div>
        <div id="btn_write" class="btn_write">글쓰기</div>
        <div id="btn_delete" class="btn_delete">삭제</div>
        <div id="btn_edit" class="btn_edit">수정</div>
    </div>
    
    <!-- article_footer -->

    </div>
    <!-- container끝 -->

</body>
</html>
