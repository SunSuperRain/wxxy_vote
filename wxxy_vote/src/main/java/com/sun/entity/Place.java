package com.sun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sun
 * @version 1.0
 * @date 2020/11/20 16:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    private Integer placeId;
    private String placeName;
    private Integer sonId;
}
