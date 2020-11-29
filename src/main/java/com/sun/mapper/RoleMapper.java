package com.sun.mapper;

import com.sun.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/18 9:43
 */
@Mapper
@Repository
public interface RoleMapper {

    List<Role> getAllRole();

    //获取用户权限
    String queryByRoleId(Integer roleId);
}
