package com.my.springbootintegratemybatis.repository;

import com.my.springbootintegratemybatis.model.SearchUserCondition;
import com.my.springbootintegratemybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
    @Insert("insert into user" +
            "(user_name,user_description," +
            "user_age,user_sex,user_remark) " +
            "values(#{name},#{description},#{age},#{sex},#{remark})")
    int addUser(User user);

    @Select("select * from user where user_id=#{id}")
    @ResultMap("user")
    User findById(@Param("id") int id);

    @Update("update user set user_name=#{name},user_age=#{age},user_description=#{description},user_remark=#{remark} where user_id=#{id}")
    int updateById(User user);

    @Delete("delete from user where user_id=#{id}")
    int deleteById(@Param("id") int id);

    @Select("select * from user order by user_name desc")
    @Results(id = "user", value = {
            @Result(column = "user_id", property = "id", id = true),
            @Result(column = "user_name", property = "name"),
            @Result(column = "user_age", property = "age"),
            @Result(column = "user_description", property = "description"),
            @Result(column = "user_sex", property = "sex"),
            @Result(column = "user_remark", property = "remark")
    })
    List<User> findAllUser();

    @ResultMap("user")
    @SelectProvider(type = UserSqlProvider.class, method = "findUsersByConditionsSql")
    List<User> findUsersByConditions(SearchUserCondition condition);
}

