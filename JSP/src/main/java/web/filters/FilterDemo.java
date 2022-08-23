package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 放行前逻辑：对req数据进行处理
        System.out.println("FILTER DEMO");

        // 放行
        chain.doFilter(request, response);

        // 放行后逻辑：对resp进行处理
        System.out.println("After filter...");
    }

    @Override
    public void destroy() {

    }
}
