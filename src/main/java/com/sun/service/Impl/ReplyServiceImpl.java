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
}
