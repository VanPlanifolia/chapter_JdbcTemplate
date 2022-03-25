<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form action="LoginCheck" method="post">
    账号<input type="text" name="userName"><br>
    密码<input type="password" name="userPass">
    <input type="submit" id="提交">
    <a href="regist.jsp">注册</a>
    <a href="query.jsp">查询</a>
</form>
</body>
</html>