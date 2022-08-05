package springaop.util2;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 自定义一个数据库事务器
 */

@Component
public class MyTransManager {

    @Autowired
    BasicDataSource basicDataSource;

    //进行保存同一个连接,static静态变量决定了使用同一个连接
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //获取连接
    public Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if(connection != null){
            return connection;
        }
        connection = basicDataSource.getConnection();
        threadLocal.set(connection);
        return connection;
    }

    //开启事务
    public void startTrans() throws SQLException {
        getConnection().setAutoCommit(false);
        System.out.println("开启");
    }

    //提交
    public void commit() throws SQLException {
        getConnection().commit();
        System.out.println("提交");
    }

    //回滚
    public void rollback() throws SQLException {
        getConnection().rollback();
        System.out.println("回滚");
    }
}
