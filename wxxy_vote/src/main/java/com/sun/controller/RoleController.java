package com.sun.controller;

import com.sun.entity.Role;
import com.sun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/17 21:02
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> getAllRole(){
        List<Role> roleList = roleService.getAllRole();
        return roleList;
    }
}
