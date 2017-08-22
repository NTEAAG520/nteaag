<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/10 0010
  Time: 上午 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片验证码测试</title>
    <style type="text/css">
        .s1{
            cursor: pointer;
        }
    </style>
</head>
<body>
验证码：<input name="vcode">
<img src="/validateCode" onclick="this.src='/validateCode?'+Math.random();" class="s1" title="点击更换">

</body>
</html>
