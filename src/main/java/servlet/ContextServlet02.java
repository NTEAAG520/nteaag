package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextServlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //[1]获取全局的上下文对象
        ServletContext servletContext = getServletContext();
        Object count = servletContext.getAttribute("count");
        if (count == null) {
            servletContext.setAttribute("count", servletContext.getInitParameter("count"));
//            servletContext.setAttribute("count", 1);
        } else {
            servletContext.setAttribute("count", Integer.parseInt(count.toString()) + 1);
        }
        out.println("总浏览数量为：" + servletContext.getAttribute("count"));

    }
}
