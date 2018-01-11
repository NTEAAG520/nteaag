<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/13 0013
  Time: 下午 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二维码生成</title>
    <style>
        body {
            background-color: #bdcac6;
        }

        .form1 {
            width: 900px;
            height: 630px;
            background-color: #ffffff;
            margin: 50px 50px 0px 50px;
        }

        .h41 {
            padding: 20px 30px 30px 30px;
        }

        .qrcontent1 {
            height: 30px;
            width: 660px;
        }

        .submit1 {
            background-color: #1c84c6;
            width: 60px;
            height: 32px;
            font-size: 17px;
            font-family: 黑体;
            margin-left: 10px;
            margin-bottom: 5px;
            color: #ffffff;
        }

        .span1 {
            font-size: 8px;
            margin-left: 120px;
            color: #aaaaaa;
        }

        .content1 {
            margin-top: 30px;
        }

        .imagecode {
            width: 265px;
            height: 240px;
            margin-left: 290px;
            margin-top: 5px;
        }

        .help-inline {
            margin-top: 2px;
        }
        h6{
            font-size: 12px;
            text-align: center;
        }

    </style>
</head>
<body>
<div class="form1">
    <form action="/QRCodeServlet" method="get">
        <div class="h41">
            <h4>二维码生成</h4>
            <hr style="border-style: inset; margin-top: 30px;">
            <div class="content1">
                二维码内容：<input class="qrcontent1" type="text" name="qrcodecontent" value="http://www.baidu.com">
                <input class="submit1" type="submit" value="生成">
                <span class="span1">请输入要生成二维码的字符串</span>
            </div>
            <hr style="border-style: inset; margin-top: 45px;">
            <div class="h42">
                <h4>二维码图像</h4>
            </div>
            <div class="image1">
                <img class="imagecode" src="show.jsp"/>
                <h6 class="help-inline">使用微信扫一扫 </h6>
            </div>
        </div>
    </form>
</div>
</body>
</html>
