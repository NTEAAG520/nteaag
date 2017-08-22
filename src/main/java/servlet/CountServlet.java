package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //获取Session对象
        HttpSession httpSession = req.getSession();
        //输出Session ID
        System.out.println(httpSession.getId());
        //获取绑定的计数器
        Integer count = (Integer) httpSession.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        //在Session中绑定计数器
        httpSession.setAttribute("count", count);
        out.println("<h3>这是第" + count + "次访问</h3>");
        out.close();
    }
}
