package springaop.util2;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 计算耗时
 */
@Component
@Aspect
public class ComputerTime {

    private Long start;
    //定义无返回值的方法，表示一个切点
    @Pointcut("execution(* springaop.service.UserServiceImp.UserServiceImp.addUser(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void getStartTime(){
        start = System.currentTimeMillis();
        System.out.println("获取开始");
    }
    @AfterReturning("pointCut()")
    public void getEndTime(){
        Long end = System.currentTimeMillis();
        System.out.println("获取结束");
        System.out.println((end - start) + "ms");
    }
}
