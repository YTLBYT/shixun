package testclass.dao;

import testclass.entity.Operation;
import testclass.entity.User;

import java.sql.SQLException;

public interface UserDao {
    void insert(User user) throws SQLException;
    void insertLog(Operation operation) throws SQLException;
}
