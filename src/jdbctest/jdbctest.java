package jdbctest;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import java.sql.*;
import java.util.List;
import java.util.Map;

public class jdbctest {
    /**
     * 测试连接整合到spring中
     */
    @Test
    public void test1() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DriverManager driverManager = ac.getBean("driverManager", DriverManager.class);
        System.out.println(driverManager);
        Connection connection = driverManager.getConnection("jdbc:mysql://localhost:3306/my_first_database", "root", "lbyt1129");
        System.out.println(connection);
    }

    /**
     * 测试工具类封装
     */
    @Test
    public void test2() throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from students_information ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("stu_num") + "--" + resultSet.getString("stu_name"));
        }
        jdbcUtil.close(resultSet, preparedStatement, connection);
    }

    /**
     * 测试spring-jdbc提供的DriverManagerDataSource
     */
    @Test
    public void test3() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DriverManagerDataSource dataSource = ac.getBean("dataSource", DriverManagerDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * jdbcTemplate测试，获取单条数据
     */
    @Test
    public void test4() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap("select * from students_information where stu_name=" + "'杨涛'");
        System.out.println(stringObjectMap);
    }

    /**
     * jdbcTemplate测试，获取多条数据
     */
    @Test
    public void test5() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select stu_num, stu_name from students_information where stu_num = '202031061211'");
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    /**
     * jdbcTemplate测试，修改
     */
    @Test
    public void test6() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        int update = jdbcTemplate.update("update students_information set stu_age = 10 where stu_num = '202031061213'");
        System.out.println(update > 0 ? "修改成功" : "修改失败");
    }

    /**
     * jdbcTemplate测试,增加
     */
    @Test
    public void test7() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        int update = jdbcTemplate.update("insert into students_information(stu_num, stu_name, stu_gender, stu_age, stu_tel) values('202031061214', '包涛', '汉族', 11, '15378590166')");
        System.out.println(update > 0 ? "增加成功" : "增加失败");
    }

    /**
     * jdbcTemplate测试,删除
     */
    @Test
    public void test8() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        int update = jdbcTemplate.update("delete from students_information where stu_num = '202031061214'");
        System.out.println(update > 0 ? "删除成功" : "删除失败");
    }

    /**
     * 测试dbcp连接池
     */
    @Test
    public void test9() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        BasicDataSource basicDataSource = ac.getBean("basicDataSource", BasicDataSource.class);
        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 测试dbcp事务
     */
    @Test
    public void test10() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        BasicDataSource basicDataSource = ac.getBean("basicDataSource", BasicDataSource.class);
        Connection connection = basicDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into students_information(stu_num, stu_name, stu_gender, stu_age, stu_tel) values('202031061214', '包涛', '汉族', 11, '15378590166')");
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "增加成功" : "增加失败");
    }
}
