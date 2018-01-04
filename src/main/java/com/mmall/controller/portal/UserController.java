package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param httpSession
     * @return
     */
    @RequestMapping(value="login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession httpSession){
        ServerResponse<User> response = userService.login(username, password);
         if (response.isSuccess()){
             httpSession.setAttribute(Const.CURRENT_USER, response.getData());
         }
        return response;
    }

    /**
     * 登出功能
     * @param httpSession
     * @return
     */
    @RequestMapping(value="logout.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession httpSession){
        //移除登录存储的session
        httpSession.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value="register.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return userService.register(user);
    }

    /**
     * 校验用户和邮箱
     * @param str
     * @param type
     * @return
     */
    @RequestMapping(value="checkValid.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type){
        return userService.checkValid(str, type);
    }

    /**
     * 获取用户信息
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "getUserInfo.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取用户信息");
    }

    /**
     * 密码提示问题
     * @param username
     * @return
     */
    @RequestMapping(value = "forgetGetQuestion.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){
        ServerResponse selectQuestion = userService.selectQuestion(username);
        return selectQuestion;
    }

    /**
     * 校验密码提示问题是否正确，使用的是本地缓存检查
     * @param username
     * @param question
     * @param answer
     * @return
     */
    @RequestMapping(value = "forgetCheckAnswer", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer){
        ServerResponse<String> checkAnswer = userService.checkAnswer(username, question, answer);
        return checkAnswer;
    }
}
