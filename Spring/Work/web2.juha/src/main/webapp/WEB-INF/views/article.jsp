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
#article_container>#btn_container {
    display: flex;
    justify-content: center;
}

#article_container>#btn_container>div {
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

#article_container>#btn_container>div * {
    text-align: center;
}

#article_container>#btn_container>#btn_good>div>#vote {
    font-weight: bold;
    font-size: 16px;
    color: red;
}

#article_container>#btn_container>.btn_good_checked>div>#vote {
    font-weight: bold;
    font-size: 16px;
    color: red;
}

#article_container>#btn_container>.btn_good_checked {
    border-color: red;
}

#article_container>#btn_container>.btn_bad_checked {
    border-color: red;
}

#article_container>#btn_container>#btn_bad>div>#vote {
    font-weight: bold;
    font-size: 16px;
    color: #474747;
}

#article_container>#btn_container>.btn_bad_checked>div>#vote {
    font-weight: bold;
    font-size: 16px;
    color: #474747;
}

#article_container>#btn_container>div:hover {
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
    width: 100%;
    display: inline-block;
}

#comment_container>#content>div {
    margin: 5px 20px 5px 20px;
    font-size: 14px;
    padding-bottom: 3px;
    display: inline-flex;
}

#comment_container>#content>#comment_no {
    display: none;
}

#comment_container>#content>#writer {
    width: 80px;
}

#comment_container>#content>#content {
    min-width: 200px;
    width: 45%;
    word-break:break-all;
}

#comment_container>#content>#regdate {
    display: inline-flex;
    font-size: 12px;
    float: right;
    align-items: center;
}

#comment_container>#content>#btn_comment_edit, #btn_comment_delete {
    display: inline-flex;
    border: black 1px solid;
    float: right;
    margin: 5px 4px 5px 2px !important;
    font-size: 12px !important;
    padding: 0px 2px 2px 2px !important;
    border-radius: 4px;
}

#comment_container>#content>#btn_comment_edit:hover, #btn_comment_delete:hover
    {
    border-color: #93bcff;
    color: #93bcff;
}

#comment_container>#edit_form {
    background-color: #e8e8e8;
    padding-bottom: 20px;
    padding: 5px 20px 30px 20px;
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

#bottom_btn_container>#btn_edit {
    float: right;
    margin-right: 10px;
}

#bottom_btn_container>#btn_delete {
    float: right;
    margin-right: 10px;
}

#bottom_btn_container>#btn_write {
    float: right;
}

#bottom_btn_container>div:hover {
    border-color: #93bcff;
    color: #93bcff;
}

#file_name {
    display: inline-flex;
    font-size: 13px;
    margin-left: 20px;
}

#file_name>div {
    margin: 0 3px;
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

var goInit = function(page) {
    window.location.href = '/articlelist/'
        + '${board_id}'
        + '/'
        + 'page='
        + page
}

var download = function( filetemp, fileorig ) {
    // post 로 요청. ajax / form
    var f  = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/download');
    f.setAttribute('enctype', 'application/x-www-form-urlencoded');
    
    var i = document.createElement('input');
    i.setAttribute('type', 'hidden');
    i.setAttribute('name', 'filetemp');
    i.setAttribute('value', filetemp);            
    f.appendChild(i);
    
    var i = document.createElement('input');
    i.setAttribute('type', 'hidden');
    i.setAttribute('name', 'fileorig');
    i.setAttribute('value', fileorig);            
    f.appendChild(i);
    
    document.body.appendChild(f);
    
    f.submit();
}

$(document).ready(function() {
	$('.btn_list').click(function(event) {
		var page = 1;
		goInit(page);
    });
	
	$('.btn_comment').click(function(event) {
		
		var comment_content = $('.comment_content').val();
		var article_subno = ${article.article_subno};
		var board_id = '${board_id}';
		
        comment_content = comment_content.replace(/\n/gi, '<br>');
		
		var comment = { 'comment_content': comment_content,
                'article_subno': article_subno,
                'board_id': board_id }
        
        $.ajax({
            url : '/comment_write'
            , data: JSON.stringify( comment )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'html'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            	$('#comment_container').children().last().prev().after(data);
            	$('.comment_content').val('');
            	
            	var tcount = $('.top_comment_count').text();
            	var bcount = $('.bottom_comment_count').text();
            	
            	tcount = Number(tcount)+1;
            	bcount = Number(bcount)+1;
            	
            	$('.top_comment_count').text(tcount);
            	$('.bottom_comment_count').text(bcount);
            	
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
	});
	
	$('.btn_login').click(function(event) {
        window.location.href = '/login';
    });
	
	$('.btn_edit').click(function(event) {
		window.location.href = '/articlelist'
		                     + '/'
		                     + '${board_id}'
		                     + '/'
		                     + 'articleedit='
		                     + '${article.article_subno}';
		
    });
	
	$('.btn_delete').click(function(event) {
		window.location.href = '/articlelist'
			                 + '/'
		                     + '${board_id}'
		                     + '/'
		                     + 'articledelete='
		                     + '${article_subno}';
    });
    
    $('.btn_logout').click(function(event) {
        $.ajax({
            url : '/log_out'
            , data: JSON.stringify( null )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'get'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'json'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if (data == 1) { 
            window.location.href = '/boardlist';
            }
            else {
                alert('정상적인 경로로 접속해주세요');
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
    });
    
    $(document).on("click",".btn_good",function(){
        if (${login_check}) {
            
            var article_no = ${article.article_no};
            var this_vote = 1;
            
            var vote = {
                    'article_no': article_no,
                    'vote': this_vote
            }
            
            $.ajax({
                url : '/article_vote'
                , data: JSON.stringify( vote )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                , type: 'post'       // get, post
                , timeout: 30000    // 30초
                , dataType: 'json'  // text, html, xml, json, jsonp, script
                , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
                , beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data == 1) { 
                    $('.btn_good').attr('class', 'btn_good_checked');
                    var c = $('.btn_good_checked').children().children('div').text();
                    c = Number(c)+1;
                    $('.btn_good_checked').children().children('div').text(c);
                }
                else {
                    alert('정상적인 경로로 접속해주세요');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
            
        }
        else {
            alert('로그인을 해야 추천이 가능합니다.');
        }
    });

    $(document).on("click",".btn_good_checked",function(){
        if (${login_check}) {
            
            var article_no = ${article.article_no};
            var this_vote = 1;
            
            var vote = {
                    'article_no': article_no,
                    'vote': this_vote
            }
            
            $.ajax({
                url : '/article_unvote'
                , data: JSON.stringify( vote )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                , type: 'post'       // get, post
                , timeout: 30000    // 30초
                , dataType: 'json'  // text, html, xml, json, jsonp, script
                , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
                , beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data == 1) { 
                    $('.btn_good_checked').attr('class', 'btn_good');
                    var c = $('.btn_good').children().children('div').text();
                    c = Number(c)-1;
                    $('.btn_good').children().children('div').text(c);
                }
                else {
                    alert('정상적인 경로로 접속해주세요');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
            
        }
        else {
            alert('로그인을 해야 추천이 가능합니다.');
        }
    });
    
    $(document).on("click",".btn_bad",function(){
        if (${login_check}) {
            
            var article_no = ${article.article_no};
            var this_vote = 0;
            
            var vote = {
                    'article_no': article_no,
                    'vote': this_vote
            }
            
            $.ajax({
                url : '/article_vote'
                , data: JSON.stringify( vote )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                , type: 'post'       // get, post
                , timeout: 30000    // 30초
                , dataType: 'json'  // text, html, xml, json, jsonp, script
                , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
                , beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data == 1) { 
                    $('.btn_bad').attr('class', 'btn_bad_checked');
                    var c = Number($('.btn_bad_checked').children().children('div').text());
                    c = c+1;
                    $('.btn_bad_checked').children().children('div').text(c);
                }
                else {
                    alert('정상적인 경로로 접속해주세요');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
            
        }
        else {
            alert('로그인을 해야 비추천이 가능합니다.');
        }
    });
    
    $(document).on("click",".btn_bad_checked",function(){
        if (${login_check}) {
            
            var article_no = ${article.article_no};
            var this_vote = 0;
            
            var vote = {
                    'article_no': article_no,
                    'vote': this_vote
            }
            
            $.ajax({
                url : '/article_unvote'
                , data: JSON.stringify( vote )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
                , type: 'post'       // get, post
                , timeout: 30000    // 30초
                , dataType: 'json'  // text, html, xml, json, jsonp, script
                , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
                , beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data == 1) { 
                    $('.btn_bad_checked').attr('class', 'btn_bad');
                    var c = Number($('.btn_bad').children().children('div').text());
                    c = c-1;
                    $('.btn_bad').children().children('div').text(c);
                }
                else {
                    alert('정상적인 경로로 접속해주세요');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
                alert('정상적인 경로로 접속해주세요');
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
            });
            
        }
        else {
            alert('로그인을 해야 비추천이 가능합니다.');
        }
    });
    
    $('.btn_logo').click(function(event) {
        window.location.href = '/boardlist';
    });
    
    $('.btn_write').click(function(event) {
        window.location.href = '/articlelist'
                             + '/'
                             + '${board_id}'
                             + '/'
                             + 'articlewrite';
    });
    
    $(document).on("click",".btn_comment_edit",function(){
    	
    	var comment_no = $(this).parents().attr('comment_no');
    	
    	var edit_form = '<div id="edit_form" style="display: inline-flex; width: 94%;">'
    	+ '<div style="width: 86%; height: 50px;">'
    	+ '<textarea class="edit_val" style="width: 100%; height: 50px;">'
    	+ '</textarea></div><div class="btn_edit_comment" style="display: inline-flex;justify-content: center;'
    	+ 'align-items: center;padding-bottom: 3px; width: 80px;height: 40px;'
    	+ 'border: #617de2 1px solid; border-radius: 4px; background-color: #93bcff;'
    	+ 'font-weight: bold;color: white; margin-left: 10px;"'
    	+ 'comment_no="' + comment_no + '">수정</div></div>';
    	var cur_data = $('div[comment_no="'+ comment_no +'"]').children('div[id="content"]').html();
    	cur_data = cur_data.replace(/<br>/gi, "\n");
    	$(this).after(edit_form);
    	$('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').children().children('textarea').val(cur_data);
    	$(this).attr('class', 'btn_comment_edit_clicked');
    });
    
    $(document).on("click",".btn_comment_edit_clicked",function(){
    	var comment_no = $(this).parents().attr('comment_no');
    	$(this).attr('class', 'btn_comment_edit');
    	$('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').remove();
    });
    
    $(document).on("click",".btn_comment_delete",function(){
        var comment_no = $(this).parents().attr('comment_no');
        if (confirm('삭제 하시겠습니까?')) {
        $.ajax({
            url : '/comment_delete'
            , data: JSON.stringify( comment_no )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'json'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if (data == 1) { 
            	$('div[comment_no="'+ comment_no +'"]').next().remove();
            	$('div[comment_no="'+ comment_no +'"]').remove();
            	
            	var tcount = $('.top_comment_count').text();
                var bcount = $('.bottom_comment_count').text();
                
                tcount = Number(tcount)-1;
                bcount = Number(bcount)-1;

                $('.top_comment_count').text(tcount);
                $('.bottom_comment_count').text(bcount);
            }
            else {
                alert('정상적인 경로로 접속해주세요');
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
        }
    });
    
    $(document).on("click",".btn_edit_comment",function(){
    	
    	var comment_no = $(this).attr('comment_no');
    	var comment_content = $('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').children().children('textarea').val();
    	
    	comment_content = comment_content.replace(/\n/gi, '<br>');
    	
    	var comment = {
    			'comment_content': comment_content,
    			'comment_no': comment_no
    	};
    	
    	$('div[comment_no="'+ comment_no +'"]').children('div[class="btn_comment_edit_clicked"]').attr('class', 'btn_comment_edit');

    	$.ajax({
            url : '/comment_edit'
            , data: JSON.stringify( comment )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'json'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if (data == 1) { 
            	$('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').remove();
            	$('div[comment_no="'+ comment_no +'"]').children('div [id="content"]').html(comment_content);
            }
            else {
                alert('정상적인 경로로 접속해주세요');
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
    });
    
    $('.btn_reg').click(function(event) {
    	window.location.href = '/register';
    })
    
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
        <div id="article_container">
            <div id="board_title">
                <div style="color: #474747;">${board_title}</div>
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
                    <div class="top_comment_count">${comment_count}</div>
                </div>
            </div>
                <div id="file_name"><div>파일 : </div><a href="javascript:download('${attachFile.filenametemp }', '${attachFile.filenameorig }')">${attachFile.filenameorig}</a></div>
            <!-- content_title end -->
            <div id="blank"></div>
            <div id="article_content">${article.article_content}</div>

            <div id="blank"></div>
            <div id="blank"></div>
            <div id="btn_container">
                <c:if test="${checkgood eq -1 or checkgood eq 0}">
                    <div id="btn_good" class="btn_good">
                        <div>
                            추천<br>
                            <div id="vote">${good_count}</div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${checkgood eq 1}">
                    <div id="btn_good" class="btn_good_checked">
                        <div>
                            추천<br>
                            <div id="vote">${good_count}</div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${checkbad eq -1 or checkbad eq 0}">
                    <div id="btn_bad" class="btn_bad">
                        <div>
                            비추천<br>

                            <div id="vote">${bad_count}</div>

                        </div>
                    </div>
                </c:if>
                <c:if test="${checkbad eq 1}">
                    <div id="btn_bad" class="btn_bad_checked">
                        <div>
                            비추천<br>

                            <div id="vote">${bad_count}</div>

                        </div>
                    </div>
                </c:if>
            </div>
            <!-- btn_container end -->

            <div id="blank"></div>
            <hr id="line">
            <div id="comment_container">
                <div id="title">
                    <div id="title">전체 댓글 수</div>
                    <div id="content" class="bottom_comment_count">${comment_count}</div>
                </div>
                <c:forEach var="comment" items="${comment_list}">
                    <div id="content" comment_no="${comment.comment_no}">
                        <div id="writer">${comment.user_id}</div>
                        <div id="content">${comment.comment_content}</div>
                        <div id="regdate">
                            <fmt:formatDate
                                value="${comment.comment_regdate}"
                                pattern="yyyy-MM-dd HH:mm:ss" />
                        </div>
                        <c:if test="${user_id eq comment.user_id}">
                            <div id="btn_comment_delete"
                                class="btn_comment_delete">삭제</div>
                            <div id="btn_comment_edit"
                                class="btn_comment_edit">수정</div>
                        </c:if>
                    </div>
                    <hr id="comment_line">
                </c:forEach>
                <c:if test="${login_check}">
                    <div id="input_form">
                        <textarea id="input_comment"
                            class="comment_content"></textarea>
                        <div id="btn_write" class="btn_comment">등록</div>
                    </div>
                </c:if>
            </div>
            <div id="blank"></div>
            <div id="bottom_btn_container">
                <div id="btn_list" class="btn_list">✅전체목록</div>
                <c:if test="${login_check}">
                    <div id="btn_write" class="btn_write">글쓰기</div>
                </c:if>
                <c:if test="${user_id eq article.user_id}">
                    <div id="btn_edit" class='btn_edit'>수정</div>
                </c:if>
                <c:if test="${user_id eq article.user_id}">
                    <div id="btn_delete" class='btn_delete'>삭제</div>
                </c:if>
            </div>
        </div>
        <!-- article_content end -->

    </div>
    <!-- container끝 -->
    <div id="footer">
            <%@ include file="../views/inc/footer.jsp"%>
        </div>
</body>
</html>