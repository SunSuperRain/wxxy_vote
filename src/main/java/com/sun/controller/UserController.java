package com.sun.controller;

import com.sun.entity.SystemUser;
import com.sun.service.UserService;
import com.sun.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/18 14:17
 */
//用户对自己信息的操作
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //获取用户个人信息
    @RequestMapping("/info")
    public String info(Model model){
        //获取当前登录的对象   存入到model中
        SystemUser systemUser = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user",systemUser);
        //判断用户权限
        if (systemUser.getRoleId() == 0){
            return "front/student/info";
        }else {
            return "front/admin/info";
        }
    }

    //用户进行注销
    @RequestMapping("/logout")
    public String logout(){
        //注销当前用户
        SecurityUtils.getSubject().logout();
        return "front/login";
    }

    //跳转到修改密码的页面
    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(Model model){
        //获取当前用户对象   将对象传入到前端
        SystemUser systemUser = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("username",systemUser.getUsername());
        return "front/password";
    }

    //用户实现修改密码的功能
    @RequestMapping("/updatePassword")
    public String updatePassword(String oldPassword,String username,Model model,String newPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SystemUser systemUser = userService.check(username, MD5.EncoderByMd5(oldPassword));
        if (systemUser == null){
            model.addAttribute("message","原密码错误");
            //不可修改密码
            return "front/password";
        }
        //修改当前用户密码
        userService.updatePassword(username,newPassword);
        //注销当前用户   返回登录页面
        SecurityUtils.getSubject().logout();
        return "front/login";
    }

    //展示用户评教信息页面   分角色进行展示
    @RequestMapping("/index")
    public String index(){
        //获取用户当前对象
        SystemUser systemUser = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        if (systemUser.getRoleId() == 0){
            //学生评教页面
            return "front/student/index";
        }else {
            //非学生评教页面
            return "front/admin/index";
        }
    }

    //用户进入评教页面
    @RequestMapping("/toEvaluation")
    public String toEvaluation(){
        return "front/evaluation";
    }

    //异步获取用户信息
    @RequestMapping("/check")
    @ResponseBody
    public String check(String username){
        userService.login(username);
        if (username == null){
            return "用户名错误";
        }
        else {
            return "";
        }
    }
}
