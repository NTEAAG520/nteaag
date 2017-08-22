package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeServlet extends HttpServlet {
    /**
     * 阶段1:实例化
     */
    public LifeServlet() {
        System.out.println("1.Constructor is running .... ");
    }

    /**
     * 阶段2:初始化
     */
    @Override
    public void init() throws ServletException {
        System.out.println("2.Init is running .... ");
    }

    /**
     * 阶段3:就绪
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("company");
        String address = config.getInitParameter("address");
        System.out.println("3.Service is running .... ");
        System.out.println("初始化参数为：" + name + "   " + address);

    }
    /**
     * 阶段4:销毁
     */
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("3.Destroy is running .... ");
    }
}
