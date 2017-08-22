<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 上午 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Now Date</title>
</head>
<body>
<div style="font-size: 20px; border: 1px solid red;width: 350px;padding: 20px">
    <%
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    %>
    当前时间为：<%=simpleDateFormat.format(date)%>
</div>
</body>
</html>
