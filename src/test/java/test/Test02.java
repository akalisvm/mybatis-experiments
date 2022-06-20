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
import java.util.List;

public class Test02 {

    @Test
    public void testQuery() throws IOException {

        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.query();
        for(User user : list) {
            System.out.println(user);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testQueryUserById() throws IOException {

        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testInsertUser() throws IOException {

        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("lory");
        user.setRealName("xiaoyan");
        user.setPassword("lory123");
        user.setAge(21);
        user.setDId(114514);
        int count = mapper.insertUser(user);

        // Mybatis对于添加、更新、删除操作关闭自动提交，需要手动提交
        sqlSession.commit();
        System.out.println("count: " + count + "\tid: " + user.getId());

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() throws IOException {

        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setUserName("lory");
        user.setRealName("xiaoyan");
        user.setPassword("lory123456");
        user.setAge(22);
        user.setDId(1919810);
        int count = mapper.updateUser(user);

        // Mybatis对于添加、更新、删除操作关闭自动提交，需要手动提交
        sqlSession.commit();
        System.out.println(count);

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() throws IOException {

        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.deleteUser(4);

        // Mybatis对于添加、更新、删除操作关闭自动提交，需要手动提交
        sqlSession.commit();
        System.out.println(count);

        // 5.关闭会话
        sqlSession.close();
    }
}
