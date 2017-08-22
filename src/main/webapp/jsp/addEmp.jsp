<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 下午 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加员工</title>
    <style>
        form {
            margin-top: 100px;
            text-align: center;
            border: 0px;
        }

        legend {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="AddEmpServlet.do" method="post">
    <fieldset>
        <legend>添加员工</legend>
        姓名：<input type="text" name="name"><br>
        薪水：<input type="text" name="salary"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="添加">
    </fieldset>
</form>
</head>

</body>
</html>
