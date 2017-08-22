<%@ page import="djlm.nteaag.dao.EmployeeDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="djlm.nteaag.bean.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 下午 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .row1 {
            background-color: #E4E4F1;
        }

        .row2 {
            background-color: #EBD10A;
        }
    </style>
    <title>员工信息列表</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0">
    <caption>员工信息</caption>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>薪水</td>
        <td>年龄</td>
    </tr>
    <%
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employeeList = dao.findAll();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
    %>
    <tr class="row<%=i%2+1%>">
        <td><%=employee.getId()%>
        </td>
        <td><%=employee.getName()%>
        </td>
        <td><%=employee.getSalary()%>
        </td>
        <td><%=employee.getAge()%>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
