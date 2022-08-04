package springzhujie;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MyDbcp {
    private BasicDataSource basicDataSource;


    public MyDbcp() {
        basicDataSource = new BasicDataSource();
        System.out.println("连接池已经被创建");
    }

    @PostConstruct
    public void init() {
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/my_first_database");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("lbyt1129");
        System.out.println("连接池已初始化");
    }

    public Connection getConnection() {
        try {
            return basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PreDestroy
    public void closeMyDbcp() {
        try {
            basicDataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("连接池关闭");
    }
}
