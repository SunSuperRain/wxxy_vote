package com.sun.service.Impl;

import com.sun.entity.Place;
import com.sun.mapper.PlaceMapper;
import com.sun.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 16:43
 */
@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceMapper placeMapper;

    //根据placeId和sonId获取位置信息
    public List<Place> getFatherPlace(){
        return placeMapper.getFatherPlace();
    }

    public List<Place> getSonPlace(Integer placeId){
        return placeMapper.getSonPlace(placeId);
    }
}
