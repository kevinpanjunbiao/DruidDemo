package com.pjb.service;

import com.pjb.entity.UserInfo;

/**
 * 用户信息业务逻辑接口
 *
 * @author pan_junbiao
 **/
public interface UserService
{
    /**
     * 根据用户ID，获取用户信息
     */
    public UserInfo getUserById(int userId);

    /**
     * 新增用户，并获取自增主键
     */
    public UserInfo insertUser(UserInfo userInfo);

    /**
     * 修改用户
     */
    public UserInfo updateUser(UserInfo userInfo);

    /**
     * 删除用户
     */
    public int deleteUser(int userId);
}
