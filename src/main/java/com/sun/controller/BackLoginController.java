package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackLoginController {

    @RequestMapping("/back/anon")
    public String backLogin(String username,String password){
        System.out.println(username + "-->" + password);
        return "back/index";
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
