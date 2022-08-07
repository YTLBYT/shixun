package mybatis_test.dao;

import mybatis_test.entiy.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 用户持久层接口
     */

    void isnert(User user);
    void update(User user);
    void delete(int stu_age);
    //多条查询
    List<User> select(Map<String, Object> paramMap);
    //单条查询
    User selectSingle(String stu_num);
}
