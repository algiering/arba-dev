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

    <h2> UploadController, DownloadController 만들기 </h2>
    <a href="/upload/uploadfile"    target="_blank">/upload/uploadfile </a> <br> 
    <a href="/upload/uploadfilelist"  target="_blank">/upload/uploadfileliste </a> <br>
    <hr />
    
    <h2> 테이블의 BLOB,CLOB 컬럼에 이미지 저장하고 가져오기</h2>   
    <a href="./upload/uploadimage"   target="_blank">./upload/uploadimage </a> <br>
    <a href="./upload/imageview/1"   target="_blank">./upload/imageview/1 </a> <br>
    <hr>
       
</body>
</html>
