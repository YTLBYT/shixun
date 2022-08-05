package springaop.service;

import springaop.entity.Operation;
import springaop.entity.User;

import java.sql.SQLException;

public interface UserService {
    void addUser(User user, Operation operation) throws Exception;
}
