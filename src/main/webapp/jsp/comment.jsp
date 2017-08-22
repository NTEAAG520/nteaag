<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/10 0010
  Time: 下午 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
<form action="/comment" method="post">
    <fieldset>
        <legend>评论</legend>
        请输入评论：<textarea name="comment" style="vertical-align: middle" width="145px" height="55px"></textarea><br>
        <input type="submit" value="发表论文">
    </fieldset>
</form>

</body>
</html>
