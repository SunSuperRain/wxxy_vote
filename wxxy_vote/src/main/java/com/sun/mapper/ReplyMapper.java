package com.sun.mapper;

import com.sun.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 14:28
 */
@Mapper
@Repository
public interface ReplyMapper {
    //根据用户角色ID获取评教内容
    List<Reply> getReply(Integer roleId);
}
