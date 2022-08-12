package web;

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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // 1. 接收用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 创建用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

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

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        // 查看是否存在该用户名
        User selectByUsername = mapper.selectByUsername(username);
        if (selectByUsername != null){
            // 存在该用户名：注册失败
            writer.write("用户名已存在，注册失败。");
        } else {
            // 不存在该用户名：可注册
            mapper.add(user);
            sqlSession.commit();
            writer.write("注册成功");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
