package com.mmall.testfile;

import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试登录
     */
    @Test
    public void testRegister(){
        User user = new User();
        user.setUsername("peter");
        user.setPassword("peter");
        user.setEmail("123@163.com");
        user.setPhone("123456");
        user.setQuestion("问题");
        user.setAnswer("答案");
        int resultCount = userMapper.insertSelective(user);
        System.out.println(resultCount);

    }

    /**
     * 测试查询用户名
     */
    @Test
    public void testQueryUsername(){
        int resultCount = userMapper.checkUsername("admin");
        System.out.println(resultCount);
    }
}
