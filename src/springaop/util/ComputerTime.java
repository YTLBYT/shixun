package springaop.util;

import org.springframework.stereotype.Component;

/**
 * 计算耗时
 */
//@Component
public class ComputerTime {

    private Long start;

    public void getStartTime(){
        start = System.currentTimeMillis();
        System.out.println("获取开始");
    }
    public void getEndTime(){
        Long end = System.currentTimeMillis();
        System.out.println("获取结束");
        System.out.println((end - start) + "ms");
    }
}
