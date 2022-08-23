package web.cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Cookie
        // 1. 获取Cookie数组
        Cookie[] cookies = request.getCookies();

        // 2. 遍历数组
        for (Cookie cookie : cookies) {
            // 3. 获取数据
            String name = cookie.getName();
            if ("username".equals(name)){
                String value = cookie.getValue();
                System.out.println(name + ": " + value);
            }
            // 使用中文Cookie - 需要URL解码
            if ("user".equals(name)){
                // URL decoding
                String value = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                System.out.println(name + ": " +value);
                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
