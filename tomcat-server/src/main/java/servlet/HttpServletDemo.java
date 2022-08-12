package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/demo2")
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get...");

        // 1. 请求行
        // 获取请求方法：GET
        String method = req.getMethod();
        System.out.println(method);

        // 获取虚拟目录/项目访问路径：/tomcat-server-war
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        // 获取URL统一资源定位符：http://localhost:8080/tomcat-server-war/demo2
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

        // 获取URI统一资源标识符：/tomcat-server-war/demo2
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        // 获取请求参数：username=zs
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // 2. 请求头
        // 获取请求头浏览器版本信息
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post...");

        // 获取请求体：请求参数
        // 1. 获取字符输入流
        BufferedReader reader = req.getReader();
        String line = reader.readLine();
        System.out.println(line);
    }
}
