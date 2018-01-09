package com.mmall.dao;

import com.mmall.common.ServerResponse;
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

    /**
     * 通过用户名查询用户设置的密码提示问题
     * @param username
     * @return
     */
    String selectQuestionByUsername(String username);

    /**
     * 校验密码提示问题是否正确
     * @param username
     * @param question
     * @param answer
     * @return
     */
    int checkAnswer(@Param("username")String username,@Param("question")String question,@Param("answer")String answer);

    /**
     * 通过用户名重置密码
     * @param username
     * @param passwordNew 新密码是MD5加密后的密码
     * @return
     */
    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);

    /**
     * 校验旧密码是否正确
     * @param password
     * @param userId
     * @return
     */
    int checkPassword(@Param("password")String password,@Param("userId")Integer userId);

    /**
     * 校验邮箱是否已经被其他用户所使用
     * @param email
     * @param userId
     * @return
     */
    int checkEmailByUserId(@Param("email")String email,@Param("userId")Integer userId);


}