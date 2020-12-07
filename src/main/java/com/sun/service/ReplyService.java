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

    //插入评教题目
    Integer insertReply(Reply reply);

    //修改评教题目
    Integer updateReply(Reply reply);

    //通过replyId获取题目内容
    Reply getReplyById(Integer replyId);

    //通过replyId删除题目
    Integer delReply(Integer replyId);

    //批量删除题目
    Integer delAllReply(String[] replyIds);
}
