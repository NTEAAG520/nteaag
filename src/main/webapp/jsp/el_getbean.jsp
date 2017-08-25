<%@ page import="bean.User" %>
<%@ page import="bean.Employee" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/25 0025
  Time: 下午 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>elTest</title>
</head>
<body>
<%--访问Bean属性--%>
<%
    User user = new User();
    user.setName("Alimjan");
    user.setPassword("654321");

    Employee employee = new Employee();
    employee.setName("Mamat");
    employee.setAge(23);

    request.setAttribute("user", user);
    request.setAttribute("employee", employee);
%>
<%--[1.1]Java代码--%>
[1.1]Java代码
<br><br>
<%
    User user1 = (User) request.getAttribute("user");
    Employee employee1 = (Employee) request.getAttribute("employee");
    out.println(user1.getName());
    out.println(user1.getPassword());
    out.println(employee1.getName());
    out.println(employee1.getAge());
%>
<%--[1.2]EL表达式--%>
<hr>
[1.2]EL表达式<br>
<%--1.2.1常用类型--%>
<h4>用户信息第一种</h4>
姓名：${user.name}<br>
密码：${user.password}
<h4>用户信息第二种（方括号形式）</h4>
姓名：${user["name"]}<br>
密码：${user['password']}
<h4>雇员信息</h4>
姓名：${employee.name}<br>
年龄：${employee.age}
<h4>雇员信息第二种（方括号形式）</h4>
姓名：${employee["name"]}<br>
年龄：${employee['age']}
<%--1.2.1引用类型--%><hr>
<p>暂时没有数据...</p>
</body>
</html>
