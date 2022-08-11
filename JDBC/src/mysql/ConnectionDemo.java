package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class ConnectionDemo {

    public static void main(String[] args) throws Exception {
        // 1. 注册驱动：可省略
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取驱动
        // url = jdbc:mysql:// + dns + port + table
        // 若mysql服务为本机以及端口为3306可简写
        // 若需要禁用安全连接方式可加useSSL参数, 多个参数之间用&隔开
        String url = "jdbc:mysql:///db1";
        String user = "root";
        String pass = "12341234";
        Connection conn = DriverManager.getConnection(url, user, pass);

        // 3. 定义SQL语句
        String sql1 = "update account set money = 2000 where id = 1";
        String sql2 = "update account set money = 2000 where id = 2";

        // 4. 获取执行sql对象的statement
        Statement statement = conn.createStatement();

        try {
            // 开启事务
            conn.setAutoCommit(false);

            // 5. 执行SQL: 返回受影响的行数
            int count1 = statement.executeUpdate(sql1);
            int count2 = statement.executeUpdate(sql2);

            // 6. 处理结果
            System.out.println(count1);
            System.out.println(count2);

            // 手动加入异常
            int i = 3/0;

            // 提交事务
            conn.commit();

        } catch (Exception e) {
            // 回滚事务
            conn.rollback();

            throw new RuntimeException(e);
        }

        // 7. 释放资源
        statement.close();
        conn.close();
    }
}
