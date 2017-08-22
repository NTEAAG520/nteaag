package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommentFilter implements Filter {
    private String illegalWord;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        illegalWord = filterConfig.getInitParameter("illegalWord");
        System.out.println("Filter1:init is running ..." + illegalWord);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        String comment = httpServletRequest.getParameter("comment");
        if (comment.endsWith("damn1")) {
            //有敏感词汇
            System.out.println("<h3>评论内容已关闭！</h3>");
            out.println("<h3>评论内容已关闭！</h3>");
        } else {
            //没有敏感词汇向后处理，交给其他过滤器或servlet处理
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
