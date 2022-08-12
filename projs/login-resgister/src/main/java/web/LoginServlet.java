package web;

import jdk.internal.loader.Resource;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;
import utils.SqlSessionFactoryUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // 1. 获取用户名和密码
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");

        // 2. 调用MyBatis查询
        // 2.1 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //String resource = "mybatis-config.xml";
        //InputStream is = Resources.getResourceAsStream(resource);
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 2.2 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.3 获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 2.4 调用方法
        User user = mapper.selectUser(username, pwd);

        // 2.5 释放资源
        sqlSession.close();

        // 3. 获取输出字符流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (user != null){
            // 登陆成功
            writer.write("登陆成功");
        } else {
            // 登陆失败
            writer.write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
