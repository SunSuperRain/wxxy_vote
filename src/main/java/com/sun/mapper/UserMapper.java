package com.sun.mapper;

import com.sun.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/18 10:02
 */
@Repository
@Mapper
public interface UserMapper {
    //用户登录的功能
    SystemUser login(String username);

    //用户修改密码的功能
    Integer updatePassword(String username,String password);

    //根据用户名和旧密码判断用户是否存在
    SystemUser check(String username,String password);
}
