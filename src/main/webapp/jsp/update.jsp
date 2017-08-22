<%@ page import="djlm.nteaag.bean.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 下午 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新员工</title>
</head>
<body>
<%
    Employee employee = (Employee) request.getAttribute("employee");
%>
<form action='ModifyEmpServlet.do?id=<%=employee.getId()%>' method='post'>

    <tr>
        <td>编号:</td>
        <td>
            <input type="text" name="id" value="<%=employee.getId()%>">
        </td>
    </tr><br>
    <tr>
        <td>姓名:</td>
        <td>
            <input type="text" name="name" value="<%=employee.getName()%>">
        </td>
    </tr><br>
    <tr>
        <td>薪水:</td>
        <td>
            <input type="text" name="salary" value="<%=employee.getSalary()%>">
        </td>
    </tr><br>
    <tr>
        <td>年龄:</td>
        <td>
            <input type="text" name="age" value="<%=employee.getAge()%>">
        </td>
    </tr><br>
    <p>
        <input type='submit' value='修改'/>
    </p>
</form>
</body>
</html>
