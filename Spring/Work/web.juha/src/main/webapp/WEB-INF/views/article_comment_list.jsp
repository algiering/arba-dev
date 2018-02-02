<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <div id="comment">
        <div>작성자</div>
        &nbsp&nbsp
        <div>
            <div id="comment_id">${comment.user_id}</div>
        </div>
        <div id="comment_edit">
            <div id="btn_recomment" class="btn_recomment">댓글</div>
            &nbsp
            <div id="btn_edit_comment" class="btn_edit_comment">수정</div>
            &nbsp
            <div id="btn_delete_comment" class="btn_delete_comment">삭제</div>
        </div>
        <div id="comment_no">${comment.comment_no}</div>
        <div id="comment_content">${comment.comment_content}</div>
        <c:forEach var="recomment" items="${recomment_list}">
            <c:if test="${recomment.comment_no eq comment.comment_no}">
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