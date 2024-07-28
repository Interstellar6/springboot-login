package com.interstellar.mapper;

import com.interstellar.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from User")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "userPassword", column = "userPassword")
    })
    User getAllUser();


    @Select("SELECT u.userName, u.userPassword FROM User u WHERE u.userName = #{userName}")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "userPassword", column = "userPassword")
    })
    User findUserByUserName(@Param("userName") String username);

    @Insert("INSERT INTO User (userId, userName, userPassword) VALUES (#{userId}, #{userName}, #{userPassword})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "userId")
    void regist(User user);

    @Select("SELECT u.userId FROM User u WHERE u.userName = #{userName} AND u.userPassword = #{userPassword}")
    Long login(User user);
}
