<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2022/7/3
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
<form action="registerUser" method="post">
学号<input type="text" name="studentId"> <br>
密码<input type="password" name="password"> <br>
<button type="submit" id="login">提交</button>
    ${repeat}
</form>
</body>
</html>
