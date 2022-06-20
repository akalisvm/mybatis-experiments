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
import java.util.Arrays;
import java.util.List;

public class Test04 {

    @Test
    public void testDynamicQueryWithIf() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("akalisvm");
        List<User> list = mapper.dynamicQueryWithIf(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicQueryWithWhere() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("akalisvm");
        List<User> list = mapper.dynamicQueryWithWhere(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicQueryWithChoose1() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("akalisvm");
        List<User> list = mapper.dynamicQueryWithChoose(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicQueryWithChoose2() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setRealName("tianang");
        List<User> list = mapper.dynamicQueryWithChoose(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicQueryWithChoose3() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        List<User> list = mapper.dynamicQueryWithChoose(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicQueryWithTrim() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("akalisvm");
        List<User> list = mapper.dynamicQueryWithTrim(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicBind() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("akali");
        List<User> list = mapper.dynamicQueryWithBind(user);
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicQueryWithForEach() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.dynamicQueryWithForEach(Arrays.asList(1, 5));
        for(User u : list) {
            System.out.println(u);
        }

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicUpdateWithSet() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setPassword("lory123456");
        user.setAge(21);
        user.setDId(1919810);
        int count = mapper.dynamicUpdateWithSet(user);

        // Mybatis对于添加、更新、删除操作关闭自动提交，需要手动提交
        sqlSession.commit();
        System.out.println(count);

        // 5.关闭会话
        sqlSession.close();
    }

    @Test
    public void testDynamicUpdateWithTrim() throws IOException {
        // 1.读取全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        // 3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 4.通过SqlSession实现数据库操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setPassword("lory123456");
        user.setAge(22);
        user.setDId(1919810);
        int count = mapper.dynamicUpdateWithTrim(user);

        // Mybatis对于添加、更新、删除操作关闭自动提交，需要手动提交
        sqlSession.commit();
        System.out.println(count);

        // 5.关闭会话
        sqlSession.close();
    }
}
