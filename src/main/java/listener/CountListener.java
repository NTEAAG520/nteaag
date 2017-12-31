package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {
    private int count = 0;

    public void sessionCreated(HttpSessionEvent se) {
        count++;
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("count", count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("count", count);
    }
}
