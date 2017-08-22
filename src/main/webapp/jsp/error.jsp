<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 下午 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误提醒</title>
</head>
<body style="font-size: 24px">

<%=request.getRequestDispatcher("err_msg") == null ? "" : request.getAttribute("err_msg")%><br>
系统异常<<a href="ListEmpServlet.do"></a>
</body>
</html>
