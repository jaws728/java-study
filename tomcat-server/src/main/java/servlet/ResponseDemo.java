package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        /**
         * 响应数据：
         * 1. 响应行：HTTP/1 200 OK
         *   - void setStatus(int status) -> 设置状态码
         * 2. 响应头：Content-Type: text/html
         *   - void setHeader(String name, String value) -> 设置响应头键值对
         * 3. 响应体：<html></html>
         *   - PrintWriter getWriter() -> 获取字符输出流
         *   - ServletOutputStream getOutputStream() -> 获取字节输出流
         */

        // 重定向
        // 1. 设置响应状态码
        response.setStatus(302);
        // 2. 设置响应头
        response.setHeader("Location", "/tomcat-server-war/demo2");
        // 简化方式
        // 动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/demo2");

        // 响应字符数据：响应体
        // 1. 获取字符输出：不需要关闭 - response会被销毁
        PrintWriter writer = response.getWriter();
        //response.setHeader("content-type", "text/html");
        response.setContentType("text/html;charset=utf-8");
        writer.write("<h1>输出<h1>");

        // 响应字节数据：音频、图片
        // 1. 读取文件
        FileInputStream fileInputStream = new FileInputStream("/Users/p/Desktop/pkcrazy/java/tomcat-server/src/main/webapp/img/regex.png");
        // 2. 获取response字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 3. 完成流的copy
        IOUtils.copy(fileInputStream, outputStream);
        fileInputStream.close();
        /*
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff, 0, len);
        }
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
