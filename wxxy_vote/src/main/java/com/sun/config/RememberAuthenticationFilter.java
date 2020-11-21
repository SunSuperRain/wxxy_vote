package com.sun.config;

import com.sun.service.UserService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/19 12:21
 */
public class RememberAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    UserService userService;
        /**
         * 这种方法决定了能否让用户登录
         */
        @Override
        protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
            Subject subject = getSubject(request, response);

            //假设 isAuthenticated 为 false 证明不是登录过的，同一时候 isRememberd 为true 证明是没登陆直接通过记住我功能进来的
            if(!subject.isAuthenticated() && subject.isRemembered()){

                //获取session看看是不是空的
                Session session = subject.getSession(true);

                //随便拿session的一个属性来看session当前是否是空的。我用userId，你们的项目能够自行发挥
                if(session.getAttribute("username") == null){

                    //假设是空的才初始化，否则每次都要初始化，项目得慢死
                    //这边依据前面的前提假设，拿到的是username
                    String username = subject.getPrincipal().toString();

                    //在这种方法里面做初始化用户上下文的事情，比方通过查询数据库来设置session值，你们自己发挥
/*                    userService.initUserContext(username, subject);*/
                }
            }

            //这种方法本来仅仅返回 subject.isAuthenticated() 如今我们加上 subject.isRemembered() 让它同一时候也兼容remember这样的情况
            return subject.isAuthenticated() || subject.isRemembered();
        }
}
