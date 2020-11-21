package com.sun.service;

import com.sun.entity.Role;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/17 15:20
 */
public interface RoleService {
    //获取所有的角色信息
    List<Role> getAllRole();

    //获取用户权限
    String queryByRoleId(Integer roleId);
}
