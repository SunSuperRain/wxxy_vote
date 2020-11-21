package com.sun.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/16 23:43
 */
//主要判断浏览器端是否含有  rememberMe的cookie信息
public class CookieUtils {
    public static Boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return false;
        }else {
            for (Cookie cookie : cookies) {
                if ("rememberMe".equals(cookie.getName())){
                    return true;
                }
            }
        }
        return false;
    }

    //得到相应的cookie信息
    public static Cookie getCookie(String cookieName,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return null;
        }else {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }

    //除去相应的cookie信息
    public static void clearCookie(String cookieName,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())){
                    //将其最大时间设置为0        关闭浏览器失效
                    cookie.setMaxAge(0);
                }
            }
        }
}
