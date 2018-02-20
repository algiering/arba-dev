<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <h1>@ModelAttribute을 이용한 로그인 처리</h1>
    <label for="id"> ID: ${login.id}  </label> 
    <br />
    <label for="pw"> PW: ${login.pw}  </label>
</body>
</html>
