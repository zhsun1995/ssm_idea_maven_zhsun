package com.laosun.service.impl;

import com.laosun.mapper.PlaceMapper;
import com.laosun.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SUN
 */
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    public PlaceMapper placeMapper;
    /**
     * 获取籍贯id
     *
     * @param name
     * @return
     */
    @Override
    public int getId(String name) {
        return placeMapper.getId(name);
    }
}
