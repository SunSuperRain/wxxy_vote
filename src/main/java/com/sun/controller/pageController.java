package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/page")
public class pageController {

    @RequestMapping("/page/index")
    public String layuiIndex(){
        return "back/index";
    }

}
