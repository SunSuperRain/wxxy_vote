package com.sun.service.Impl;

import com.sun.entity.SystemUser;
import com.sun.mapper.UserMapper;
import com.sun.service.UserService;
import com.sun.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/18 10:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public SystemUser login(String username) {
        return userMapper.login(username);
    }

    @Override
    public Integer updatePassword(String username,String password) {
        //对密码进行加密
        try {
            password = MD5.EncoderByMd5(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userMapper.updatePassword(username,password);
    }

    @Override
    public SystemUser check(String username, String password) {
        return userMapper.check(username,password);
    }

    /**
     * 获取所有的用户
     * @return
     */
    @Override
    public List<SystemUser> findAllUser() {
        List<SystemUser> allUser = userMapper.findAllUser();
        return allUser;
    }

    /**
     * 通过角色ID，用户信息
     * @param id
     * @return
     */
    @Override
    public List<SystemUser> findUserByRoleId(Integer id) {
        List<SystemUser> userByRoleId = userMapper.findUserByRoleId(id);
        return userByRoleId;
    }

    /**
     * 获取所有督察组的用户
     * @return
     */
    @Override
    public List<SystemUser> findUserOnAdmin() {
        List<SystemUser> userOnAdmin = userMapper.findUserOnAdmin();
        return userOnAdmin;
    }

    /**
     * 传入一个用户的实体类，来插入到数据库中
     * @param user
     * @return
     */
    @Override
    public Integer insertUserService(SystemUser user) {
        Integer integer = userMapper.insertUser(user);
        return integer;
    }

    /**
     * 使用用户名来删除用户信息
     * @param username
     * @return
     */
    @Override
    public Integer delUserService(String username) {
        Integer integer = userMapper.delUser(username);
        return integer;
    }

    /**
     * 使用用户名批量删除数据
     * @param split
     * @return
     */
    @Override
    public Integer batchDeleteUser(String[] split) {
        Integer integer = userMapper.batchDeleteUser(split);
        return integer;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public Integer updateServiceUser(SystemUser user) {
        Integer integer = userMapper.updateUser(user);
        return integer;
    }

}
