package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class JDBCDemo {

    public static void main(String[] args) throws Exception {
        // 1. 注册驱动：可省略
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取驱动
        // url = jdbc:mysql:// + dns + port + table
        // 若mysql服务为本机以及端口为3306可简写
        // 若需要禁用安全连接方式可加useSSL参数, 多个参数之间用&隔开
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        url = "jdbc:mysql:///db1?useSSL=false";
        String user = "root";
        String pass = "12341234";
        Connection conn = DriverManager.getConnection(url, user, pass);

        // 3. 定义SQL语句
        String sql = "update account set money = 2000 where id = 1";

        // 4. 获取执行sql对象的statement
        Statement statement = conn.createStatement();

        // 5. 执行SQL: 返回受影响的行数
        int count = statement.executeUpdate(sql);

        // 6. 处理结果
        System.out.println(count);

        // 7. 释放资源
        statement.close();
        conn.close();
    }
}
