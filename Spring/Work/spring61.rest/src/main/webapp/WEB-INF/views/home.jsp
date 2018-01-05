<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>
<p><a href="/rest/selectuserlist" target="_blank">/rest/selectuserlist</a></p>
<hr>

<h1>User</h1>
<p> <a href="/rest/curtime" target="_blank">/rest/curtime</a> </p>
<p> <a href="/rest/selectuserlist" target="_blank">/rest/selectuserlist</a> </p>
<p> <a href="./rest/login?userid=test1id&passwd=test1pw" target="_blank"> "/rest/login?id=test1id&pw=test1pw" </a></p>
<p> <a href="./rest/login?userid=userid&passwd=passwd" target="_blank"> "/rest/login?userid=userid&passwd=passwd" </a></p>
<p> <a href="./rest/checkuserid?userid=userid" target="_blank"> "/rest/checkuserid?serid=userid" </a></p>
<p> <a href="./rest/checkuserid?userid=asdfasdf" target="_blank"> "/rest/checkuserid?serid=asdfasdf" </a></p>
<p> <a href="./rest/updatepasswd?userid=userid&currentPasswd=passwd&newPasswd=newpw" target="_blank"> "/rest/updatepasswd?userid=userid&currentPasswd=password&newPasswd=newpw" </a></p>
<hr>

<h1>@RequestBody 실습</h1>
<p> <a href="./rest/insertuser?userid=tester1&email=tester" target="_blank"> "/rest/insertuser?userid=tester1&email=tester"" </a></p>
<p> <a href="./rest/insertuser?userid=tester1&email=tester" target="_blank"> "/rest/insertuser?userid=tester1&email=tester"" </a></p>
<hr>

<h1>Board</h1>
<p> <a href="/rest/getboardone?boardcd=free" target="_blank">/rest/getboardone?boardcd=free</a> </p>
<p> <a href="/rest/getboardone?cd=free" target="_blank">/rest/getboardone?cd=free</a> </p>


</body>
</html>
