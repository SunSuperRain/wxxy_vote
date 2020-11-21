package com.sun.controller;

import com.sun.config.RestResponse;
import com.sun.entity.Role;
import com.sun.entity.SystemUser;
import com.sun.service.RoleService;
import com.sun.utils.CookieUtils;
import com.sun.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/17 14:48
 */
@Controller
public class LoginController {

    @Autowired
    RoleService roleService;

    //跳转到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "front/login";
    }

    //用户进行登录请求
    @RequestMapping("/login")
    public String login(SystemUser systemUser, Model model,Boolean rememberMe) throws Exception{
        //获取用户当前对象
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据    获取到了Token令牌对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(systemUser.getUsername(),MD5.EncoderByMd5(systemUser.getPassword()));
        //判断用户是否记住我
        if (null != rememberMe){
            usernamePasswordToken.setRememberMe(true);
        }

        //执行登录方法
        try {
            subject.login(usernamePasswordToken);
            //获取当前用户对象
            SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
            //判断用户权限是否正确
            if (user.getRoleId() == systemUser.getRoleId()){
                //判断用户权限信息
                if (user.getRoleId() == 0){
                    return "front/student/index";
                }
                return "front/admin/index";
            }else {
                model.addAttribute("message","用户权限错误,请重新输入");
                return "front/login";
            }
        } catch (UnknownAccountException e) {
            //返回登录页面
            model.addAttribute("message","用户名不存在，请重新输入");
            return "front/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误，请重新输入");
            return "front/login";
        }
    }

    //用户实现记住我功能  跳转投票页面
    @RequestMapping("/toIndex")
    public String toIndex(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        //获取当前用户对象
        SystemUser systemUser = (SystemUser) subject.getPrincipal();
        if (CookieUtils.checkCookie(request)){
            if (systemUser.getRoleId() == 0){
                return "front/student/index";
            }
            return "front/admin/index";
        }
        //没有实现记住我功能  跳转到登录页面
        return "front/login";
    }

    //获取所有的角色信息    异步请求
    //获取所有教师的信息
    @RequestMapping("/roleList")
    @ResponseBody
    public RestResponse List(){
        List<Role> roleList = roleService.getAllRole();
        if(roleList.size() != 0){
            HashMap hashMap = (HashMap) roleList;
            return  RestResponse.ok(hashMap);
        }
        return RestResponse.fail(200,"请求数据异常");
    }
}
