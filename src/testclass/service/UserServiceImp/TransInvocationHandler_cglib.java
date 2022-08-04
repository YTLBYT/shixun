package testclass.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;
import testclass.util.MyTransManager;

import java.lang.reflect.Method;

@Component("transInvocationHandle_cglib")
public class TransInvocationHandler_cglib implements InvocationHandler {

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
