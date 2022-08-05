package springaop.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springaop.dao.UserDao;
import springaop.entity.Operation;
import springaop.entity.User;
import springaop.service.UserService;

import java.sql.SQLException;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user, Operation operation) throws Exception {
        userDao.insert(user);
        userDao.insertLog(operation);
    }
}
