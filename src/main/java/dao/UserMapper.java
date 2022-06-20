package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> query();
    public User queryUserById(Integer id);
    public Integer insertUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id);
    public List<User> dynamicQueryWithIf(User user);
    public List<User> dynamicQueryWithWhere(User user);
    public List<User> dynamicQueryWithChoose(User user);
    public List<User> dynamicQueryWithTrim(User user);
    public List<User> dynamicQueryWithBind(User user);
    public List<User> dynamicQueryWithForEach(@Param("ids") List<Integer> ids);
    public Integer dynamicUpdateWithSet(User user);
    public Integer dynamicUpdateWithTrim(User user);
}
