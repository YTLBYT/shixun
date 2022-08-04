package testclass.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testclass.entity.Operation;
import testclass.entity.User;
import testclass.service.UserService;
import testclass.util.MyTransManager;

import java.sql.SQLException;

@Service
public class UserServiceImpProxy implements UserService {

    @Autowired
    private UserService userService;

    @Autowired
    private MyTransManager myTransManager;

    @Override
    public void addUser(User user, Operation operation) throws SQLException{
        System.out.println("执行代理方法");
        try {
            myTransManager.startTrans();
            userService.addUser(user, operation);
            myTransManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            myTransManager.rollback();
        }
    }
}
