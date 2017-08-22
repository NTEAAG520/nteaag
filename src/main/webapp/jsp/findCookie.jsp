<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/9 0009
  Time: 下午 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FindCookie</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            out.println("<h3>Name:" + name + "      Value:" + value+"</h3>");
        }
    }else {
        out.println("没有cookie");
    }
%>
</body>
</html>
