package springaop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springaop.entity.Operation;
import springaop.entity.User;
import springaop.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringAop {

    @Autowired
    @Qualifier("userServiceImp")
    private UserService userService;

    @Test
    public void test1(){
        User user = new User("202031061216", "杨雨", "汉族", 13, "19283965717");
        Operation operation = new Operation();
        operation.setUid("001");
        operation.setName("yt");
        try {
            userService.addUser(user,operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
