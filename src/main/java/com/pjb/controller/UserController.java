package com.pjb.controller;

import com.pjb.entity.UserInfo;
import com.pjb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户信息控制器
 * @author pan_junbiao
 **/
@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     */
    @RequestMapping("getUserById")
    public ModelAndView getUserById(int userId)
    {
        //根据用户ID，获取用户信息
        UserInfo userInfo = userService.getUserById(userId);

        if (userInfo == null)
        {
            userInfo = new UserInfo();
        }

        //返回结果
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("/user-info.html");
        return modelAndView;
    }

    /**
     * 新增用户
     */
    @ResponseBody
    @RequestMapping("insertUser")
    public boolean insertUser()
    {
        //创建新用户
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("pan_junbiao的博客");
        userInfo.setAge(32);
        userInfo.setBlogUrl("https://blog.csdn.net/pan_junbiao");
        userInfo.setBlogRemark("您好，欢迎访问 pan_junbiao的博客");

        //执行新增方法
        userService.insertUser(userInfo);

        //返回结果
        return userInfo.getUserId() > 0 ? true : false;
    }

    /**
     * 修改用户
     */
    @ResponseBody
    @RequestMapping("updateUser")
    public boolean updateUser(int userId)
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName("pan_junbiao的博客_02");
        userInfo.setAge(35);
        userInfo.setBlogUrl("https://blog.csdn.net/pan_junbiao");
        userInfo.setBlogRemark("您好，欢迎访问 pan_junbiao的博客");

        //执行修改方法
        userService.updateUser(userInfo);

        //返回结果
        return true;
    }

    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping("deleteUser")
    public boolean deleteUser(int userId)
    {
        //执行新增方法
        int result = userService.deleteUser(userId);

        //返回结果
        return result > 0 ? true : false;
    }
}
