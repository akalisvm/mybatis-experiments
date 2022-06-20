package test;

import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class Test03 {

    @Test
    public void testCache() throws IOException {

        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println("第一次获取User对象（从数据库获取）：" + user);
        System.out.println("----------");
        // 一级缓存中如果有数据的话，就直接从一级缓存获取数据，而不会进行数据库的操作
        User user1 = mapper.queryUserById(1);
        System.out.println("第二次获取User对象（从一级缓存获取）：" + user1);
        System.out.println("----------");
        // 如果关闭数据库连接，一级缓存会被清空，下次查询必须重新进行数据库的操作
        // 如果开启二级缓存，MyBatis会去二级缓存查找数据
        sqlSession.close();
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
        User user2 = mapper.queryUserById(1);
        System.out.println("第三次获取User对象（从数据库获取）：" + user2);

        // 5.关闭会话
        sqlSession.close();
    }
}
