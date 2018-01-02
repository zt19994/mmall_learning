package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 通过用户名查询用户是否存在
     * @param username
     * @return
     */
    int checkUsername(String username);

    /**
     * 通过id查询用户是否存在
     * @param email
     * @return
     */
    int checkEmail(String email);

    User selectLogin(@Param("username") String username, @Param("password") String password);


}