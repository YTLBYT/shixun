package testclass.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import testclass.util.MyTransManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * 事务管理增强的一个模板
 * 事务管理的工具类
 * ！！！不是一个代理类！！！
 */
@Component
public class TransInvocationHandler implements InvocationHandler {

    //引入真实的业务对象
    @Autowired
    @Qualifier("userServiceImp")
    private Object target;

    public Object getTarget() {
        return target;
    }

    //引入事务管理器-需要增强的功能
    @Autowired
    MyTransManager myTransManager;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        try {
            myTransManager.startTrans();
            invoke = method.invoke(target, args);
            myTransManager.commit();
        }catch (Exception e){
            myTransManager.rollback();
        }
        return invoke;
    }
}

