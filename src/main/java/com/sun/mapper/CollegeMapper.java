package com.sun.mapper;

import com.sun.entity.College;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 学院专业的Mapper类
 * @Author: 张豆豆
 * @Date: 2020-12-08 08:27:16
 */
@Mapper
@Repository
public interface CollegeMapper {

    //获取所有的学院专业
    List<College> getColleges();

    //通过collegeNo获取专业名
    String findCollegeNO(Integer collegeNo);

}
