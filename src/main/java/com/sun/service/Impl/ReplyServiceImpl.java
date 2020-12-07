package com.sun.service.Impl;

import com.sun.entity.Reply;
import com.sun.mapper.ReplyMapper;
import com.sun.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 14:33
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Reply> getReply(Integer roleId) {
        return replyMapper.getReply(roleId);
    }

    @Override
    public Integer insertReply(Reply reply) {
        Integer integer = replyMapper.insertReply(reply);
        return integer;
    }

    @Override
    public Integer updateReply(Reply reply) {
        Integer integer = replyMapper.updateReply(reply);
        return integer;
    }

    @Override
    public Reply getReplyById(Integer replyId) {
        Reply replyById = replyMapper.getReplyById(replyId);
        return replyById;
    }

    @Override
    public Integer delReply(Integer replyId) {
        Integer integer = replyMapper.delReply(replyId);
        return integer;
    }

    @Override
    public Integer delAllReply(String[] replyIds) {
        Integer integer = replyMapper.batchDelete(replyIds);
        return integer;
    }
}
