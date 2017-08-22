<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/9 0009
  Time: 下午 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCookie</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("userName", "Ahmatjan");
    cookie.setPath("/alimjan");
    response.addCookie(cookie);
%>

</body>
</html>
