package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
public class ResultSetDemo {

    public static void main(String[] args) throws Exception {
        // 1. 注册驱动：可省略
        //Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取驱动
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String user = "root";
        String pass = "12341234";
        Connection conn = DriverManager.getConnection(url, user, pass);

        // 3. 定义SQL语句
        String sql = "select * from account";

        // 4. 获取执行sql对象的statement
        Statement statement = conn.createStatement();

        // 5. 执行SQL: 返回受影响的行数
        ResultSet resultSet = statement.executeQuery(sql);

        // 6. 处理结果
        // 6.1  光标向下移动一行，判断是否存在数据
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");

            System.out.println(id);
            System.out.println(name);
            System.out.println("------------");
        }

        // 7. 释放资源
        resultSet.close();
        statement.close();
        conn.close();
    }
}
