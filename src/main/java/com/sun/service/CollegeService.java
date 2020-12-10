package com.sun.service;

import com.sun.entity.College;

import java.util.List;

/**
 * @Description: 学院专业类的Service层
 * @Author: 张豆豆
 * @Date: 2020-12-08 08:30:56
 */
public interface CollegeService {

    //获取所有的学院专业
    List<College> getColleges();

    //通过collegeNo获取专业名
    String findCollegeNO(Integer collegeNo);
}
