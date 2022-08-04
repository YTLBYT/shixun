package testclass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testclass.entity.Operation;
import testclass.entity.User;
import testclass.service.UserService;

import javax.annotation.Resource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")

public class test {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {

        User user = new User("202031061216", "杨雨", "汉族", 13, "19283965717");
        Operation operation = new Operation();
        operation.setUid("001");
        operation.setName("yt");
        try {
            userService.addUser(user,operation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
