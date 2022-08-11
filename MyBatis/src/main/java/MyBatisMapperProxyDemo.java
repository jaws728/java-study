import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pck
 * @description 使用Mapper代理开发
 */
public class MyBatisMapperProxyDemo {
    public static void main(String[] args) throws IOException {
        // 1. 加载MyBatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取SqlSession对象，用于执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // SqlSession sqlSession = sqlSessionFactory.openSession(true); 自动提交事务

        // 3. 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        // 接收参数
        int status = 1;
        String addr = "road";
        // 处理参数
        addr = "%" + addr + "%";
        List<User> u = userMapper.selectByCondition(status, addr);

        // 封装对象
        User user = new User();
        user.setAddr(addr);
        List<User> u1 = userMapper.selectByCondition(user);

        Map map = new HashMap();
        map.put("status", status);
        map.put("addr", addr);
        List<User> u2 = userMapper.selectByCondition(map);

        System.out.println(users);

        // 若是添加数据则需提交才生效, 或者在开启session的时候可传入true参数 - 如上
        // sqlSession.commit();

        // 4. 释放资源
        sqlSession.close();
    }
}
