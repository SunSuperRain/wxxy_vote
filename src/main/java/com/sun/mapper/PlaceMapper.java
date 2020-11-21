package com.sun.mapper;

import com.sun.entity.Place;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 16:42
 */
@Mapper
@Repository
public interface PlaceMapper {
    //根据placeId和sonId获取位置信息
    List<Place> getFatherPlace();

    List<Place> getSonPlace(Integer placeId);
}
