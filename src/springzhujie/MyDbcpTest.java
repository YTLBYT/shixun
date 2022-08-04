package springzhujie;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class MyDbcpTest {
    @Test
    public void test() {
        MyDbcp myDbcp = new MyDbcp();
        myDbcp.init();
        Connection connection = myDbcp.getConnection();
        System.out.println(connection);
    }

    @Autowired
    MyDbcp myDbcp;

    @Test
    public void test1() {
        Connection connection = myDbcp.getConnection();
        System.out.println(connection);
    }
}
