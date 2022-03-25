<%--
  Created by IntelliJ IDEA.
  User: 崔震云
  Date: 2022/3/25
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="QueryServlet" method="post">
        账号<input type="text" name="UserName"><br>
        <input type="submit" value="查询单个">
    </form>
    <form action="FindAllServlet" method="post">
        <input type="submit" value="查询全部">
    </form>
</head>
<body>
</body>
</html>
