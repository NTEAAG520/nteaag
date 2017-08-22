package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommentFilter2 implements Filter {
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
        if (comment.length() > 15) {
            //有敏感词汇
            out.println("<h3>评论太长了，稍微减缩吧！</h3>");
            out.println("<h5><a href='/jsp/comment.jsp'>返回评论页面</a></h5>");

        } else {
            //没有敏感词汇向后处理，交给其他过滤器或servlet处理
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
