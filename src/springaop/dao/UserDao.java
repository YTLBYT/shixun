package springaop.dao;

import springaop.entity.Operation;
import springaop.entity.User;

import java.sql.SQLException;

public interface UserDao {
    void insert(User user) throws Exception;
    void insertLog(Operation operation) throws Exception;
}
