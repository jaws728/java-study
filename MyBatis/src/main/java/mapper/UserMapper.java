package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author pck
 * @description Mapper接口：用于Mapper代理开发
 */
public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    /**
     * 条件查询 - 参数接收
     *  1. 散装参数：若多个方法中有多个参数，则需使用@Param("SQL参数占位符名称")
     *  2. 对象参数：对象的属性名称要和参数占位符名称一致
     *  3. map集合参数
     *
     * @param status
     * @param addr
     * @return
     */
    List<User> selectByCondition(@Param("status") int status, @Param("addr") String addr);

    List<User> selectByCondition(User user);

    List<User> selectByCondition(Map map);

    /**
     * 注解开发：简单的SQL语句可使用注解
     */
    @Select("select * from tb_user where id = #{id}")
    User selectById1(int id);
}
