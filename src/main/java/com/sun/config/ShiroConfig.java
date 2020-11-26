package com.sun.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.sun.service.UserService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/15 23:20
 */
@Configuration
public class ShiroConfig {

    @Autowired
    UserService userService;

    //记住我
    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //这个地方有点坑，不是所有的base64编码都可以用，长度过大过小都不
        cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j3Y+R1aSn5BOlAA=="));
        return cookieRememberMeManager;
    }

    //cookie管理
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(1 * 60 * 60 * 24 * 14);
        return cookie;
    }

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        //添加Shiro的内置过滤器
        /*
        * anon:无需认证就可以访问
        * authc 必须认证才能访问
        * user 必须实现记住我功能才能使用
        * perms 拥有对某个资源的权限才能访问
        * role 拥有某个角色才能访问
        * */

        //建立map集合
        Map<String,String> filterChainDefinitionMap = new HashMap<>();

        //在记住我功能下  访问所有的页面信息
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //所有角色都可以访问登录页面  发送登录请求
        filterChainDefinitionMap.put("/login","anon");
        //异步请求  允许访问
        filterChainDefinitionMap.put("/role/roleList","anon");

        //用户实现记住我的功能   可以访问任何界面
        filterChainDefinitionMap.put("/toIndex","user");
        filterChainDefinitionMap.put("/user/**","user");

        //自定义登录页面   发请求到controller层
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        //静态资源的放行
        // 静态资源放行
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/fontawesome/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");

        //后台拦截器
        filterChainDefinitionMap.put("/back/login","anon");
        filterChainDefinitionMap.put("/back/anon","anon");
        filterChainDefinitionMap.put("/back/reg","anon");
        filterChainDefinitionMap.put("/back/forget","anon");
        filterChainDefinitionMap.put("/back/**","authc");

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //打开记住我的功能
        return shiroFilterFactoryBean;
    }

    //自定义的shiro标签
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm,@Qualifier("rememberMeManager") RememberMeManager rememberMeManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //管理realm对象
        defaultWebSecurityManager.setRealm(userRealm);
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager);
        return defaultWebSecurityManager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //创建过滤对象
    @Bean
    public RememberAuthenticationFilter rememberAuthenticationFilter(){
        return new RememberAuthenticationFilter();
    }
}
