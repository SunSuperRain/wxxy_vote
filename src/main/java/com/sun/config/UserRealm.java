package com.sun.config;

import com.sun.entity.SystemUser;
import com.sun.service.RoleService;
import com.sun.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/15 23:22
 */
//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //设置授权对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前用户对象
        SystemUser systemUser = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        //设置当前用户的权限
        info.addRole(roleService.queryByRoleId(systemUser.getRoleId()));
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //创建令牌对象
        //获取controller层传递过来的用户信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        if (userService.login(userToken.getUsername()) == null){
            //会向controller层抛出用用户名不存在的异常
            return null;
        }
        //密码认证  shiro自动完成
        SystemUser systemUser = userService.login(userToken.getUsername());

        return new SimpleAuthenticationInfo(systemUser,userService.login(userToken.getUsername()).getPassword(),"user");
    }
}
