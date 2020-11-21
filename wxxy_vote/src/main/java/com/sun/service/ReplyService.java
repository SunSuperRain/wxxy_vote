package com.sun.service;

import com.sun.entity.Reply;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 14:32
 */
public interface ReplyService {
    //根据用户角色ID获取评教内容
    List<Reply> getReply(Integer roleId);
}
