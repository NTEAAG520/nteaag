<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/25 0025
  Time: 上午 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线人数</title>
</head>
<body>
当前共有<%=application.getAttribute("count").toString()%>人在线<br>
<a href="/LogoutServlet">登出</a>
</body>
</html>
