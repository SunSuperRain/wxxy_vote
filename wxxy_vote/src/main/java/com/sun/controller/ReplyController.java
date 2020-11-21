package com.sun.controller;

import com.sun.entity.Reply;
import com.sun.entity.SystemUser;
import com.sun.service.ReplyService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 14:33
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    //根据权限id获取用户评教内容
    @RequestMapping("/getReply")
    public String getReply(Model model){
        //获取当前用户对象
        SystemUser systemUser = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        List<Reply> replyList = replyService.getReply(systemUser.getRoleId());
        model.addAttribute("list",replyList);
        return "front/evaluation";
    }
}
