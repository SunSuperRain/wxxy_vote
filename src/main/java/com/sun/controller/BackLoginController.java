package com.sun.controller;

import com.sun.entity.SystemUser;
import com.sun.service.UserService;
import com.sun.utils.MD5;
import com.sun.utils.Msg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class BackLoginController {

    @ResponseBody
    @RequestMapping("/back/anon")
    public Msg backLogin(String username, String password) throws Exception {
        //获取用户当前对象
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据    获取到了Token令牌对象
        UsernamePasswordToken token = new UsernamePasswordToken(username,MD5.EncoderByMd5(password));
        try {
            subject.login(token);
            SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
            //判断用户权限信息
            if (user.getRoleId() == 2 || user.getRoleId() == 3){
                    return Msg.success();
            }else {
                return Msg.fail().add("mc_msg","用户权限错误,请重新输入!");
            }
        } catch (UnknownAccountException e) {
            return Msg.fail().add("mc_msg","用户不存在，请先注册!");
        } catch (IncorrectCredentialsException e){
            return Msg.fail().add("mc_msg","密码错误!");
        }
    }

    @RequestMapping("/back/reg")
    public String backReg(){
        return "back/reg";
    }

    @RequestMapping("/back/forget")
    public String backForget(){
        return "back/forget";
    }
}
