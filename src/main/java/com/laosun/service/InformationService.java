package com.laosun.service;

import com.laosun.pojo.Information;
import com.laosun.pojo.InformationExtend;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author SUN
 * @version V1.0
 * @date 2020.04.24
 */
public interface InformationService {
    /**
     * 增
     * @param information
     * @return
     */
    public int add(Information information);

    /**
     * 删
     * @param uid
     * @return
     */
    public void delete(int uid);

    /**
     * 改
     * @param information
     * @return
     */
    public int update(Information information);

    /**
     * 查单
     * @param id
     * @return
     */
    public Information get(int id);

    /**
     * 查多
     * @return
     */
    public List<InformationExtend> list();

    /**
     * 按条件查多
     * @param map
     * @return
     */
    public List<InformationExtend> list(Map<String, String> map);

    /**
     * 返回最大的Uid
     * @return
     */
    public int maxUid();

}
