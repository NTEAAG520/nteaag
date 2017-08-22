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

public class ModifyEmpServlet extends HttpServlet {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/nteaag";
    public static final String USER = "root";
    public static final String PASSWORD = "123.";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        double salary = Double.valueOf(req.getParameter("salary"));
        int age = Integer.valueOf(req.getParameter("age"));

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE emp SET name=?,salary=?,age=? WHERE id=?");


            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, salary);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            resp.sendRedirect("ListEmpServlet");
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
