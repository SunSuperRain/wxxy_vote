package com.sun.service.Impl;

import com.sun.entity.Role;
import com.sun.mapper.RoleMapper;
import com.sun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/17 15:20
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public String queryByRoleId(Integer roleId) {
        return roleMapper.queryByRoleId(roleId);
    }
}
