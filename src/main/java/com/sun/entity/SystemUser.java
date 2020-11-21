package com.sun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/18 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String systemName;
    private String classNo;
    private String collegeNo;
    private Integer roleId;
}
