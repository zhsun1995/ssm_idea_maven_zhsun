package com.laosun.service;

import org.apache.ibatis.annotations.Select;

/**
 * @author SUN
 */
public interface PlaceService {
    /**
     * 获取籍贯id
     * @param name
     * @return
     */
    public int getId(String name);
}
