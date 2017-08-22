package servlet;


import bean.Employee;
import dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //[1]获取请求资源路径
        String uri = req.getRequestURI();
        //[2]获取请求资源路径中除应用名以外的部分
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        System.out.println("action:"+action);
        if (action.equals("ListEmpServlet")) {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            try {
                List<Employee> employees = employeeDAO.findAll();
                out.println("<html>");
                out.println("<head></head>");
                out.println("<body>");
                out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%' >");
                out.println("<caption>员工信息列表</caption>");
                out.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td><td colspan='2'>操作</td></tr>");
                for (Employee employee : employees) {
                    out.println("<tr>" +
                            "<td>" + employee.getId() + "</td>" +
                            "<td>" + employee.getName() + "</td>" +
                            "<td>" + employee.getSalary() + "</td>" +
                            "<td>" + employee.getAge() + "</td>" +
                            "<td><a href='DeleteEmpServlet?id=" + employee.getId() + "'" +
                            "onclick=\"return confirm('是否确定删除员工："
                            + employee.getName() + "');\">删除</a></td>" +
                            "<td><a href='LoadEmpServlet?id=" + employee.getId() + "'>修改</a></td>" +
                            "</tr>");
                }
                out.println("</table>");
                out.print("<a href='addEmp.html'>增加员工信息</a>");
                out.println("</body>");
                out.println("</html>");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("系统繁忙，请稍后再试！");
            }
        }
        if (action.equals("AddEmpServlet")) {
            String name = req.getParameter("name");
            double salary = Double.parseDouble(req.getParameter("salary"));
            int age = Integer.parseInt(req.getParameter("age"));
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSalary(salary);
            employee.setAge(age);
            EmployeeDAO employeeDAO1 = new EmployeeDAO();
            try {
                employeeDAO1.save(employee);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("系统繁忙，请稍后再试！");
            }
        }
    }
}
