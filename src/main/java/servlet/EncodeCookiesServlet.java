package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class EncodeCookiesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //创建Cookies
        String name = URLEncoder.encode("阿里木·吐尔逊", "UTF-8");
        Cookie cookie = new Cookie("userName", name);
        Cookie cookie2 = new Cookie("userEmail", "237*******@qq.com");
        //添加到Cookies Response中
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
    }
}
