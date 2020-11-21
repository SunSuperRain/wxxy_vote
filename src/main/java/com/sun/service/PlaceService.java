package com.sun.service;

import com.sun.entity.Place;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 16:43
 */
public interface PlaceService {
    //根据placeId和sonId获取位置信息
    List<Place> getFatherPlace();

    List<Place> getSonPlace(Integer placeId);
}
