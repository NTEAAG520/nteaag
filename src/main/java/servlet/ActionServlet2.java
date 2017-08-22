package servlet;


import bean.Employee;
import bean.User;
import dao.EmployeeDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ActionServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //[1]获取请求资源路径
        String uri = req.getRequestURI();
        //[2]获取请求资源路径中除应用名以外的部分
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        if (action.equals("ListEmpServlet")) {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            try {
                List<Employee> employees = employeeDAO.findAll();
                req.setAttribute("employees", employees);
                req.getRequestDispatcher("listEmp2.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                //编程式的处理异常
                req.setAttribute("err_msg", "系统出错，请重试！");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
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
                resp.sendRedirect("ListEmpServlet.do");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                //将异常抛给容器，在web.xml文件中添加声明，变成声明式的处理异常
                throw new ServletException(e);
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("系统繁忙，请稍后再试！");
                //将异常抛给容器，在web.xml文件中添加声明，变成声明式的处理异常
                throw new ServletException(e);
            }
        }
        if (action.equals("DeleteEmpServlet")) {
            int id = Integer.parseInt(req.getParameter("id"));
            EmployeeDAO employeeDAO2 = new EmployeeDAO();
            try {
                employeeDAO2.delete(id);
                resp.sendRedirect("ListEmpServlet.do");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                //将异常抛给容器，在web.xml文件中添加声明，变成声明式的处理异常
                throw new ServletException(e);
            } catch (SQLException e) {
                e.printStackTrace();
                //将异常抛给容器，在web.xml文件中添加声明，变成声明式的处理异常
                throw new ServletException(e);
            }
        }
        if (action.equals("LoadEmpServlet")) {
            int id = Integer.parseInt(req.getParameter("id"));
            EmployeeDAO employeeDAO2 = new EmployeeDAO();
            try {
                Employee employee = employeeDAO2.findById(id);
                req.setAttribute("employee", employee);
                req.getRequestDispatcher("update.jsp").forward(req, resp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                //编程式的处理异常
                req.setAttribute("err_msg", "系统出错，请重试！");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                //编程式的处理异常
                req.setAttribute("err_msg", "系统出错，请重试！");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
        if (action.equals("ModifyEmpServlet")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double salary = Double.parseDouble(req.getParameter("salary"));
            int age = Integer.parseInt(req.getParameter("age"));
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSalary(salary);
            employee.setAge(age);
            employee.setId(id);
            EmployeeDAO employeeDAO1 = new EmployeeDAO();
            try {
                employeeDAO1.modify(employee);
                resp.sendRedirect("ListEmpServlet.do");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                //编程式的处理异常
                req.setAttribute("err_msg", "系统出错，请重试！");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                //编程式的处理异常
                req.setAttribute("err_msg", "系统出错，请重试！");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
        if (action.equals("regist")) {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String gender = req.getParameter("sex");
            UserDAO userDAO = new UserDAO();
            try {
                User user=userDAO.findByUserName(userName);
                if (user != null) {
                    req.setAttribute("regist_err", "用户名已经存在");
                    req.getRequestDispatcher("regist.jsp").forward(req, resp);
                }else {
                    user = new User();
                    user.setUserName(userName);
                    user.setPassword(password);
                    user.setName(name);
                    user.setGender(gender);
                    userDAO.save(user);
                    resp.sendRedirect("login.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }
        if (action.equals("login")) {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            UserDAO userDAO = new UserDAO();
            try {
                User user = userDAO.findByUserName(userName);
                if (user == null || !user.getPassword().equals(password)) {
                    req.setAttribute("login_err","用户名或密码错误");
                    req.getRequestDispatcher("regist.jsp").forward(req, resp);
                }else {
                    resp.sendRedirect("ListEmpServlet.do");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
