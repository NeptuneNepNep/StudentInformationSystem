<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2022/7/1
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="checkLogin" method="post">
    <div id="div1">
            学号<input type="text" name="studentId"> <br>
            密码<input type="password" name="password"> <br>
            <button type="submit" id="login">提交</button>
            <button type="button" name="register" id="register">注册</button>
                    ${charge}



    </div>
</form>

</body>
<script>
    let register = document.querySelector("#register");
    register.onclick=function (e){
        console.log(e);
        window.open("register.jsp");


    }




</script>
</html>
