package testclass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testclass.entity.Operation;
import testclass.entity.User;
import testclass.service.UserService;
import testclass.service.UserServiceImp.TransInvocationHandler_cglib;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")

public class test {


    /**
     * 事务管理测试
     */

/*    @Autowired
    private UserService userService;
    @Test
    public void test1() {

        User user = new User("202031061216", "杨雨", "汉族", 13, "19283965717");
        Operation operation = new Operation();
        operation.setUid("001");
        operation.setName("yt");
        try {
            userService.addUser(user,operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 静态代理实现事务管理，进行业务增强
     */

/*    @Autowired
    @Qualifier("userServiceImpProxy")
    private UserService userService;
    @Test
    public void test2(){
        User user = new User("202031061211", "杨雨", "汉族", 13, "19283965717");
        Operation operation = new Operation();
        operation.setUid("001");
        operation.setName("yt");
        try {
            userService.addUser(user,operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 测试jdk动态代理
     */

/*    @Autowired
    private TransInvocationHandler transInvocationHandler;
    @Test
    public void test3() {
        //生成代理类
        //使用反射机制
        //第一个参数：真实业务对象对应类型的类加载器
        //第二个参数：真实业务对象对应的真实业务类实现的接口
        //第三个参数：模板-就是告诉jdk需要生成的代理类
        UserService userService = (UserService) Proxy.newProxyInstance(transInvocationHandler.getTarget().getClass().getClassLoader(),
                transInvocationHandler.getTarget().getClass().getInterfaces(),
                transInvocationHandler);
        User user = new User("202031061216", "杨雨", "汉族", 13, "19283965717");
        Operation operation = new Operation();
        operation.setUid("001");
        operation.setName("yt");
        try {
            userService.addUser(user, operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 测试cglib动态代理
     */
    @Autowired
    TransInvocationHandler_cglib transInvocationHandler_cglib;
    @Test
    public void test4(){
        //spring框架提供了一个Enhancer类型
        Enhancer enhancer = new Enhancer();
        //使用该对象设置相关的属性
        //设置生成的代理类继承的类--设置业务类类型
        enhancer.setSuperclass(transInvocationHandler_cglib.getTarget().getClass());
        //设置代理类需要做什么事情
        enhancer.setCallback(transInvocationHandler_cglib);
        //根据当前的设置创建代理类
        UserService userService = (UserService)enhancer.create();
        User user = new User("202031061216", "杨雨", "汉族", 13, "19283965717");
        Operation operation = new Operation();
        operation.setUid("001");
        operation.setName("yt");
        try {
            userService.addUser(user, operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
