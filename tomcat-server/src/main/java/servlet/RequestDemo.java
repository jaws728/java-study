package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/req-demo")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get获取参数方式：
        //String queryString = req.getQueryString();
        //System.out.println(queryString);
        // --- 为了优化以上，将post和get获取参数方式放进map集合中

        // 1. 获取map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + ": ");
            // 获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
        }

        // 2. 根据key获取参数
        System.out.println("Hobbies:");
        for (String hobby : req.getParameterValues("hobby")) {
            System.out.println(hobby);
        }

        // 3. 根据key获取单个参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username" + username);
        System.out.println("password" + password);

        // 解决中文乱码问题
        // 1. post请求乱码解决方案：设置字符输入流的编码
        req.setCharacterEncoding("UTF-8");
        // 2. get请求乱码解决方案
        // 原因：浏览器通过URL编码发送至服务端，浏览器编码用UTF-8，而Tomcat使用的解码是ISO-8859-1
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(username);

        // 存储数据
        req.setAttribute("req1", "request");
        // 请求转发
        req.getRequestDispatcher("/demo1").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Post获取参数方式：
        //BufferedReader reader = req.getReader();
        //String line = reader.readLine();
        //System.out.println(line);

        this.doGet(req, resp);
    }
}
