package com.sun.service;

import com.sun.entity.SystemUser;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/18 10:04
 */
public interface UserService {
    SystemUser login(String username);

    //用户修改密码的功能
    Integer updatePassword(String username,String password);

    //根据用户名和旧密码判断用户是否存在
    SystemUser check(String username,String password);

    //获取所有的用户
    List<SystemUser> findAllUser();

    //根据角色来获取用户信息
    List<SystemUser> findUserByRoleId(Integer id);
}
