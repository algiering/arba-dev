<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/spring/loginmodelpost" method="post"
enctype="application/x-www-form-urlencoded">
<label for="name">이름 : <input type="text" name="name" /></label>
<label for="phone">폰 : <input type="text" name="phone" /></label>
<input type="submit" value="전송" />
</form>

</body>
</html>