package com.sun.service.Impl;

import com.sun.entity.College;
import com.sun.mapper.CollegeMapper;
import com.sun.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 学院专业类Service层的实现类
 * @Author: 张豆豆
 * @Date: 2020-12-08 08:33:43
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    /**
     * 获取所有的专业类
     * @return
     */
    @Override
    public List<College> getColleges() {
        List<College> colleges = collegeMapper.getColleges();
        return colleges;
    }

    /**
     * 通过专业号来获取专业名
     * @param collegeNo
     * @return
     */
    @Override
    public String findCollegeNO(Integer collegeNo) {
        String college = collegeMapper.findCollegeNO(collegeNo);
        return college;
    }
}
