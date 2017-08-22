<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 上午 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object name = session.getAttribute("username");
    if (name == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<head>
    <title>My First JSP</title>
</head>
<body style="font-size: 20px">
<%--使用out.print("Hello JSP"); 方式输出--%>
<% for (int i = 0; i < 10; i++) {
    out.println("Hello jsp");
}%>
<hr>
<!--使用<%="Hello JSP"%> 方式输出 -->
<%for (int i = 0; i < 10; i++) { %>
<%="No." + (i + 1) + "Hello JSP"%><br>
<%
    }%>
<h3>首页</h3>欢迎您：<%=name.toString()%><br><Br><br>
<a href="../index.jsp">登出</a>
</body>
</html>
