package springaop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springaop.dao.UserDao;
import springaop.entity.Operation;
import springaop.entity.User;
import springaop.util2.MyTransManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class UserDaoImpl implements UserDao {
/*    @Autowired
    private BasicDataSource basicDataSource;*/

    @Autowired
    private MyTransManager myTransManager;

    @Override
    public void insert(User user) throws Exception {
            Connection connection = myTransManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into students_information(stu_num,stu_name,stu_gender,stu_age,stu_tel) values(?,?,?,?,?)");
            preparedStatement.setString(1, user.getStu_num());
            preparedStatement.setString(2, user.getStu_name());
            preparedStatement.setString(3, user.getStu_gender());
            preparedStatement.setInt(4, user.getStu_age());
            preparedStatement.setString(5, user.getStu_tel());
            int i = preparedStatement.executeUpdate();
//            System.out.println(i > 0 ? "增加成功" : "增加失败");
    }

    @Override
    public void insertLog(Operation operation) throws Exception {
            Connection connection = myTransManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into log values (?,?)");
            preparedStatement.setString(1, operation.getUid());
            preparedStatement.setString(2, operation.getName());
            double B = 10/0;
            int i = preparedStatement.executeUpdate();
//            System.out.println(i > 0 ? "增加成功" : "增加失败");
    }
}
