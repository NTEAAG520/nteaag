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
    <title>注册</title>
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
<form action="regist.do" method="post">
    <fieldset>
        <legend>注册</legend>
        <tr>
            <td>用户名:</td>
            <td>
                <input type="text" name="username">
                <%
                    String errorMsg = (String) request.getAttribute("regist_err");
                %>
                <span style="color: red"><%=errorMsg == null ? "" : errorMsg%></span>
            </td>
        </tr>
        <br>
        <tr>
            <td>真实姓名:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <br>
        <tr>
            <td>密码:</td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <br>
        <tr>
            <td>性别:</td>
            <td>
                男
                <input type="radio" name="sex" value="m" checked="checked">
                女
                <input type="radio" name="sex" value="f">
            </td>
        </tr>
        <br>
        <p>
            <input type='submit' value='Submit &raquo;'/>
        </p>
    </fieldset>
</form>
</head>
</body>
</html>
