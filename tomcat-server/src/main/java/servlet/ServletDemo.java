package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebServlet("/demo1")
@WebServlet(urlPatterns = "/demo1", loadOnStartup = 1) //提高创建优先级
public class ServletDemo implements Servlet {
    private ServletConfig config;

    /**
     * 初始化方法
     * 1. 调用时机：默认为Servlet第一次访问
     *      * loadOnStartup: 通过改变值来改变调用init方法的优先级
     * 2. 调用次数：1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Init Servlet...");
    }

    /**
     * 获取Servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet started...");

        // 获取转发资源
        Object req1 = servletRequest.getAttribute("req1");
        System.out.println(req1);
        servletRequest.removeAttribute("req1");
    }

    /**
     * 获取Servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 1. 调用时机：内存释放或者服务器关闭时
     * 2. 调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("Destroying Servlet...");
    }
}
