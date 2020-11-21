package com.sun.controller;

import com.sun.entity.Place;
import com.sun.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 16:51
 */
@Controller
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    //根据placeId和sonId获取信息
    //异步获取地点信息
    @RequestMapping("/getFatherPlace")
    @ResponseBody
    public List<Place> getFatherPlace(){
        List<Place> fatherPlace = placeService.getFatherPlace();
        return placeService.getFatherPlace();
    }

    @RequestMapping("/getSonPlace")
    @ResponseBody
    public List<Place> getSonFather(Integer placeId){
        return placeService.getSonPlace(placeId);
    }
}
