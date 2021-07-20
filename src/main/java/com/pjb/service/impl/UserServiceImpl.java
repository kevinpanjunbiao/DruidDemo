package com.pjb.service.impl;

import com.pjb.entity.UserInfo;
import com.pjb.mapper.UserMapper;
import com.pjb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息业务逻辑类
 * @author pan_junbiao
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户ID，获取用户信息
     */
    @Override
    public UserInfo getUserById(int userId)
    {
        return userMapper.getUserById(userId);
    }

    /**
     * 新增用户，并获取自增主键
     */
    @Override
    public UserInfo insertUser(UserInfo userInfo)
    {
        userMapper.insertUser(userInfo);
        return userInfo;
    }

    /**
     * 修改用户
     */
    @Override
    public UserInfo updateUser(UserInfo userInfo)
    {
        userMapper.updateUser(userInfo);
        return userInfo;
    }

    /**
     * 删除用户
     */
    @Override
    public int deleteUser(int userId)
    {
        return userMapper.deleteUser(userId);
    }
}