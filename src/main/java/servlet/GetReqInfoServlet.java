package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetReqInfoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/htm");
        resp.setCharacterEncoding("UTF-8");
        //将文本在页面上输出
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        if (!(name.equals("") || password.equals(""))) {
            System.out.println("姓名：" + name);
            System.out.println("密码：" + password);
        } else {
            System.out.println("参数获取失败！");
        }
    }
}
