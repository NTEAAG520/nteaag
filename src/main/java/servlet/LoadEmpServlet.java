package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoadEmpServlet extends HttpServlet {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/nteaag";
    public static final String USER = "root";
    public static final String PASSWORD = "123.";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT *  FROM emp WHERE id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            out.println("<html><head></head><body style='font-size:15px;'>");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                int age = resultSet.getInt("age");
                out.println("<form action='ModifyEmpServlet' method='post'>");
                out.println("编号：" + id + "<br>");
                out.println("<input type='hidden' name='id' value='" + id + "'/><br>");
                out.println("姓名：<input name='name' value='" + name + "'/><br>");
                out.println("薪水：<input name='salary' value='" + salary + "'/><br>");
                out.println("年龄：<input name='age' value='" + age + "'/><br>");
                out.println("<input type='submit' value='修改'/>");
                out.println("</form>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("系统繁忙，请稍后再试！");
        } catch (SQLException e) {
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
