package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 找到当前路：/Users/p/Desktop/pkcrazy/java/JDBC
        System.out.println(System.getProperty("user.dir"));

        // 1. 导入jar

        // 2. 定义配置文件

        // 3. 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 4. 获取连接池对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        // 5. 获取数据库连接
    }
}
