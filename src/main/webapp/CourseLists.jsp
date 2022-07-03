<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2022/7/1
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

    <title>Title</title>
</head>
<body>
<h1>你的成绩是</h1>
<table border="1px">
    <tr>
    <th>姓名</th>
    <th>课程</th>
    <th>教师</th>
    <th>成绩</th>
    <th>评级</th>
    <th>学分</th>
    </tr>
    <c:forEach items="${courseScoreLists}" var="course">
        <tr>
        <td>${course.studentName}</td>
        <td>${course.courseName}</td>
        <td>${course.teacherName}</td>
        <td>${course.score}</td>
        <td>${course.level}</td>
        <td>${course.credit}</td>
        </tr>
    </c:forEach>




</table>

</body>
</html>
