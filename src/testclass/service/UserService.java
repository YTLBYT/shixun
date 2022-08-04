package testclass.service;

import testclass.entity.Operation;
import testclass.entity.User;

import java.sql.SQLException;

public interface UserService {
    void addUser(User user, Operation operation) throws SQLException, Exception;
}
