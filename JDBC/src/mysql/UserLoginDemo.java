package mysql;

import java.sql.*;

public class UserLoginDemo {

    public static void main(String[] args) throws Exception {
        // 1. 正常登陆：
        // 接收用户输入的用户名和密码
        String name = "zs";
        String pwd = "1234";
        login(name, pwd);

        // 2. SQL注入演示
        name = "something";
        pwd = "' or '1' = '1";
        login(name, pwd);
        // 最后的SQL语句为：select * from db1 where username = 'something' and password = '' or '1' = '1'
        // 解释：用户名和密码的and结果为false，但是最后结果or执行出来的结果为true，因此登陆成功

        // 解决SQL注入：使用PreparedStatement -- 会进行转译：'将变成文本
        preparedLogin(name, pwd);
    }

    public static void login(String name, String pwd) throws Exception {

        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String user = "root";
        String pass = "12341234";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = "select * from db1 where username = '" + name + "' and password = '" + pwd + "'";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        resultSet.close();
        statement.close();
        conn.close();
    }

    public static void preparedLogin(String name, String pwd) throws Exception {

        //开启预编译功能
        String url = "jdbc:mysql://127.0.0.1:3306/db1?userServerPrepStmts=true";
        String user = "root";
        String pass = "12341234";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = "select * from db1 where username = ? and password = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        resultSet.close();
        preparedStatement.close();
        conn.close();
    }
}
