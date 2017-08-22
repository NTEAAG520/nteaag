package servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ListEmpServlet extends HttpServlet {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/nteaag";
    public static final String USER = "root";
    public static final String PASSWORD = "123.";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //[1] 链接数据库
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM emp");
            resultSet = preparedStatement.executeQuery();
            //[2]输出表格之前的页面标记
            out.println("<html>");
            out.println("<head></head>");
            out.println("<body>");
            out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%' >");
            out.println("<caption>员工信息列表</caption>");
            out.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td><td colspan='2'>操作</td></tr>");
            //[2]遍历结果集，以表格形式输出数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                int age = resultSet.getInt("age");
                out.println("<tr>" +
                        "<td>" + id + "</td>" +
                        "<td>" + name + "</td>" +
                        "<td>" + salary + "</td>" +
                        "<td>" + age + "</td>" +
                        "<td><a href='DeleteEmpServlet?id=" + id  + "'" +
                        "onclick=\"return confirm('是否确定删除"
                        + name + "');\">删除</a></td>" +
                        "<td><a href='LoadEmpServlet?id=" + id + "'>修改</a></td>" +
                        "</tr>");
            }
            out.println("</table>");
            out.print("<a href='addEmpTest.html'>增加员工信息</a>");
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("系统繁忙，请稍后再试！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
