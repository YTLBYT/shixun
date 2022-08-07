package mybatis_test.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 提供sqlSession方法
 * sqlSession来源于sqlSessionFactory
 * sqlSessionFactory又是通过sqlSessionFactoryBuilder创建
 */

public class MyBatisUtil {
    //先声明一个SqlSessionFactory
    public static SqlSessionFactory sqlSessionFactory;

    static {
        //创建一个sqlSessionFactory工具
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        try {
            //先要加载到我们核心的配置文件
            InputStream stream = Resources.getResourceAsStream("mybatisConfig.xml");
            sqlSessionFactory = builder.build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取sqlSession
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }
}