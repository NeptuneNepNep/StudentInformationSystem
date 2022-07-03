<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2022/7/1
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
<h1>欢迎${studentId}</h1>
<form action="checkScores" method="get">
    <h1>点击按钮查询你的成绩</h1>
    <button type="submit">查询</button>
</form>

</body>
</html>
