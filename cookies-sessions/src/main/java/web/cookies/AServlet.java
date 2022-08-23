package web.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送cookie
        // 1. 创建cookie对象
        Cookie cookie = new Cookie("username", "zs");
        // 设置存活时间：1周=7天=60*60*24*7秒
        cookie.setMaxAge(60*60*24*7);
        // 2. 发送cookie.response
        response.addCookie(cookie);

        // 若需要中文：则需要进行编码 → URL编码
        String value = "张三";
        value = URLEncoder.encode(value, StandardCharsets.UTF_8);
        Cookie c = new Cookie("user", value);
        response.addCookie(c);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
