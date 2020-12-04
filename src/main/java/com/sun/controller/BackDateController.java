package com.sun.controller;

import com.sun.config.PageUtil;
import com.sun.entity.Reply;
import com.sun.entity.Role;
import com.sun.entity.SystemUser;
import com.sun.service.ReplyService;
import com.sun.service.RoleService;
import com.sun.service.UserService;
import com.sun.utils.MD5;
import com.sun.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 获取数据库中是数据然后发送到视图层
 * @Author: 张豆豆
 * @Date: 2020-11-28 16:26:03
 */
@Controller
public class BackDateController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //获取学生评教题目的信息
    @RequestMapping("/back/reply")
    @ResponseBody
    public RestResponse<HashMap> replyDates(Integer page, Integer limit){

        //获取评教题目的对象
        List<Reply> reply = replyService.getReply(0);

        //把list对象，转换为json数据
        if(reply.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(reply, page, limit, reply.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //获取评教题目的信息
    @RequestMapping("/back/reply_tea")
    @ResponseBody
    public RestResponse<HashMap> replyTeaDates(Integer page, Integer limit){

        //获取评教题目的对象
        List<Reply> reply = replyService.getReply(1);

        //把list对象，转换为json数据
        if(reply.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(reply, page, limit, reply.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //获取评教题目的信息
    @RequestMapping("/back/reply_lea")
    @ResponseBody
    public RestResponse<HashMap> replyLeaDates(Integer page, Integer limit){

        //获取评教题目的对象
        List<Reply> reply = replyService.getReply(2);

        //把list对象，转换为json数据
        if(reply.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(reply, page, limit, reply.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //获取评教题目的信息
    @RequestMapping("/back/reply_cen")
    @ResponseBody
    public RestResponse<HashMap> replyCenDates(Integer page, Integer limit){

        //获取评教题目的对象
        List<Reply> reply = replyService.getReply(2);

        //把list对象，转换为json数据
        if(reply.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(reply, page, limit, reply.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //所有用户信息
    @RequestMapping("/back/systemuser")
    @ResponseBody
    public RestResponse<HashMap> userDates(Integer page, Integer limit){

        //获取所有用户对象
        List<SystemUser> allUser = userService.findUserOnAdmin();

        //把list对象，转换为json数据
        if(allUser.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(allUser, page, limit, allUser.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //管理员信息
    @RequestMapping("/back/useradmin")
    @ResponseBody
    public RestResponse<HashMap> adminDates(Integer page, Integer limit){

        //获取所有管理员信息
        List<SystemUser> userByRoleId = userService.findUserByRoleId(3);

        //把list对象，转换为json数据
        if(userByRoleId.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(userByRoleId, page, limit, userByRoleId.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //获取所有角色
    @RequestMapping("/back/role")
    @ResponseBody
    public RestResponse<HashMap> roleDates(Integer page, Integer limit){

        //获取所有管理员信息
        List<Role> userByRoleId = roleService.getAllRole();

        //把list对象，转换为json数据
        if(userByRoleId.size() != 0){
            //变成一个hashMap
            HashMap hashMap = PageUtil.PageByList(userByRoleId, page, limit, userByRoleId.size());
            //转换为json数据
            return RestResponse.ok(hashMap);
        }
        //转换失败
        return RestResponse.fail(200,"数据等待异常!");
    }

    //学生题目管理
    @RequestMapping("/back/user/changePwd")
    @ResponseBody
    public RestResponse changePwd(String username,String oldPassword,String repassword) {
        SystemUser login = userService.login(username);
        try {
            String password = MD5.EncoderByMd5(oldPassword);
            if(!login.getPassword().equals(password)) {
                return RestResponse.fail(200,"当前密码错误，请重新输入!");
            } else {
                Integer integer = userService.updatePassword(username, repassword);
                return RestResponse.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RestResponse.fail(200,"修改密码错误!");
    }

}
