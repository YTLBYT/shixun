package mybatis_test.dao.imp;

import mybatis_test.dao.UserDao;
import mybatis_test.entiy.User;
import mybatis_test.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDaoImp implements UserDao {
    @Override
    public void isnert(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int insert = sqlSession.insert("mybatis_test.dao.UserDao.insert", user);
        System.out.println(insert);
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int update = sqlSession.update("mybatis_test.dao.UserDao.update", user);
        System.out.println(update);
    }

    @Override
    public void delete(int stu_age) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int delete = sqlSession.delete("mybatis_test.dao.UserDao.delete", stu_age);
        System.out.println(delete);
    }

    @Override
    public List<User> select(Map<String, Object> paramMap) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectList("mybatis_test.dao.UserDao.selectList", paramMap);
    }

    @Override
    public User selectSingle(String stu_num) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectOne("mybatis_test.dao.UserDao.selectSingle", stu_num);
    }
}
