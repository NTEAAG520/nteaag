package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ActionServlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //[1]获取请求资源路径
        String uri = req.getRequestURI();
        //[2]获取请求资源路径中除应用名以外的部分
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        HttpSession session = req.getSession();
        System.out.println("sessionId: " + session.getId());
        if (action.equals("index")) {
            String name = req.getParameter("username");
            String password = req.getParameter("password");
            String number = req.getParameter("vcode").toUpperCase();
            String code = session.getAttribute("code").toString();
            if (number.equals(code) && name.equals("alimjan") && password.equals("123.")) {
                session.setMaxInactiveInterval(10);
                session.setAttribute("username", name);
                resp.sendRedirect(resp.encodeRedirectURL("/jsp/hello.jsp"));
            } else {
                req.setAttribute("msg", "用户名或密码错误！");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } else if (action.equals("hello")) {
            session.invalidate();
            resp.sendRedirect("../index.jsp");

        }
        out.close();
    }
}
