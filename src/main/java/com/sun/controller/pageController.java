package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {

    @RequestMapping("/page/index")
    public String layuiIndex(){
        return "back/index";
    }

    @RequestMapping("/home/console")
    public String layuiConsole(){
        return "back/home/console";
    }

    @RequestMapping("/template/addresslist")
    public String layuiAdd(){
        return "back/template/addresslist";
    }

    @RequestMapping("/administrators/list-person")
    public String layuiListPerson(){
        return "back/user/administrators/list-person";
    }

    @RequestMapping("/administrators/list")
    public String layuiList(){
        return "back/user/administrators/list";
    }

    @RequestMapping("/administrators/role")
    public String layuiRole(){
        return "back/user/administrators/role";
    }

    @RequestMapping("/set/user/info")
    public String layuiInfo(){
        return "back/set/user/info";
    }

    @RequestMapping("/set/user/password")
    public String layuiPass(){
        return "back/set/user/password";
    }

    @RequestMapping("/timu")
    public String layuiTimu(){
        return "back/user/user/timu";
    }
}
