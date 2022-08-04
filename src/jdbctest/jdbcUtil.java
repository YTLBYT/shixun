package jdbctest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 抽取工具类
 */

public class jdbcUtil {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        driverClassName = bundle.getString("driverClassName");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭连接
     */
    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
