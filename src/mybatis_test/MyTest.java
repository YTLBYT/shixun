package mybatis_test;

import mybatis_test.dao.UserDao;
import mybatis_test.dao.imp.UserDaoImp;
import mybatis_test.entiy.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test_insert(){
        UserDao userDao = new UserDaoImp();
        User user = new User("202031061216", "杨雨", "汉族", 13, "19283965717");
        userDao.isnert(user);
    }

    @Test
    public void tset_update(){
        UserDao userDao = new UserDaoImp();
        User user = new User();
        user.setStu_name("杨雨彤");
        user.setStu_num("202031061215");
//        System.out.println(user);
        userDao.update(user);
    }

    @Test
    public void tset_delete(){
        UserDao userDao = new UserDaoImp();
        userDao.delete(13);
    }

    @Test
    public void tset_selectone(){
        UserDao userDao = new UserDaoImp();
        User user = userDao.selectSingle("202031061211");
        System.out.println(user);
    }

    @Test
    public void tset_select(){
        UserDao userDao = new UserDaoImp();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("stu_num", "20");
        List<User> users = userDao.select(stringObjectHashMap);
        for(User user:users){
            System.out.println(user);
        }
    }
}
