package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param pwd
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{pwd}")
    User selectUser(@Param("username") String username, @Param("pwd") String pwd);

    /**
     * 用于查询是否存在该用户名
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    /**
     * 用于添加/注册用户
     * @param user
     */
    @Insert("insert into tb_user values(null, #{username}, #{password})")
    void add(User user);
}
