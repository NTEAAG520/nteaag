package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmpServlet extends HttpServlet {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/nteaag";
    public static final String USER = "root";
    public static final String PASSWORD = "123.";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        String name = req.getParameter("name").trim();
        Double salary = Double.valueOf(req.getParameter("salary").trim());
        Integer age = Integer.valueOf(req.getParameter("age").trim());

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "\"INSERT into emp(name, salary, age) \"+name+\",\"+salary+\",\"+age+\"\"";
            statement = connection.prepareStatement("INSERT into emp VALUES (?,?,?,?)");
            statement.setString(2, name);
            statement.setDouble(3, salary);
            statement.setInt(4, age);
            statement.setInt(1, 0);
            statement.executeUpdate();
            printWriter.println("添加成功！");
            resp.sendRedirect("ListEmpServlet");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter.println("系统繁忙，请稍后再试！");
        }finally {
            if (statement != null) {
                try {
                    statement.close();
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
