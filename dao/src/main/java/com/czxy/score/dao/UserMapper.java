package com.czxy.score.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tab_user WHERE username = #{username} AND password = #{password}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password")
    })
    public User findUserByNameAndPsw(User user);
}
