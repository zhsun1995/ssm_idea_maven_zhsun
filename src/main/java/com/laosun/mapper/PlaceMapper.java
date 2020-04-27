package com.laosun.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author SUN
 * @version V1.0
 * @date 2020.04.24
 */
public interface PlaceMapper {
    /**
     * 获取籍贯id
     * @param name
     * @return
     */
    @Select("select id from native_place where name = #{name}")
    public int getId(String name);
}
