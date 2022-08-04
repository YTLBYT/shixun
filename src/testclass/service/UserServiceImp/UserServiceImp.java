package testclass.service.UserServiceImp;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testclass.dao.UserDao;
import testclass.entity.Operation;
import testclass.entity.User;
import testclass.service.UserService;
import testclass.util.MyTransManager;

import javax.annotation.Resource;
import java.sql.SQLException;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 侵入了事务管理器方法，废弃
     */
/*    @Autowired
    private MyTransManager myTransManager;

    @Override
    public void addUser(User user, Operation operation) throws SQLException {
        myTransManager.startTrans();
        try {
            userDao.insert(user);
            userDao.insertLog(operation);
            myTransManager.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            myTransManager.rollback();
        }
    }*/

    /**
     * 静态代理方法
     */

    @Override
    public void addUser(User user, Operation operation) throws Exception {
        userDao.insert(user);
        userDao.insertLog(operation);
    }
}
