package com.sun.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 快捷添加信息的方法
 *
 * @author wrz
 * @data 2019/10/30-20:02
 */
public class Msg {

    //状态码 100：成功 200：失败
    private int code;

    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }

    public static Msg fail() {
        Msg result1 = new Msg();
        result1.setCode(200);
        result1.setMsg("处理失败");
        return result1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

}
