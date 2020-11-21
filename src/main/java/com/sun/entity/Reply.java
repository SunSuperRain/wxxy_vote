package com.sun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 14:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private Integer replyId;
    private String title;
    private String content;
    private Integer roleId;
    private double weight;
    private String kind;
}
