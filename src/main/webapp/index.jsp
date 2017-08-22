<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/7
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<body>
<div id="div1" class="text-center">
    <h3>系统登录</h3>
    <div id="div2">
        <div>
            <img id="image" src="resource/logo-blue.png">
        </div>
        <form id="form1" action="../index.do" method="post">
            <div id="input1">
                <input id="name" type="text" class="input" name="username" placeholder="登录账号"
                       data-validate="required:请填写账号!,length#>=0:账号长度不符合要求"><br>
            </div>
            <div id="input2">
                <input id="pass" type="password" class="input" name="password" placeholder="登录密码"
                       data-validate="required:请填写密码!,length#>=0:密码长度不符合要求"><br>
                <span class="icon icon-user"></span>
            </div>
            <div id="input3">
                <input id="vcode" type="text" class="input" name="vcode" placeholder="验证码"
                       data-validate="required:请填写验证码!">
                <img id="image2" src="/validateCode" onclick="this.src='/validateCode?'+Math.random();" class="s1" title="点击更换"><br>
                <span class="icon icon-user"></span>
            </div>
            <div id="auto">
                <label>
                    <input type="checkbox" name="checkbox" checked/>自动登录
                    <span style="color: #818181;font-size: 10px">（公共电脑不建议自动登录，以防账号丢失）</span>
                </label><br><br>
            </div>
            <div id="submit">
                <button id="btn1" value="submit" name="submit">登录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
