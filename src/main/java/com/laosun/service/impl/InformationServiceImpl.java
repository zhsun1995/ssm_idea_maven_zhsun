package com.laosun.service.impl;

import com.laosun.mapper.InformationMapper;
import com.laosun.pojo.Information;
import com.laosun.pojo.InformationExtend;
import com.laosun.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author SUN
 * @version V1.0
 * @date 2020.04.24
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;
    /**
     * 增
     *
     * @param information
     * @return
     */
    @Override
    public int add(Information information) {
        return informationMapper.add(information);
    }

    /**
     * 删
     *
     * @param uid
     * @return
     */
    @Override
    public void delete(int uid) {
        informationMapper.delete(uid);
    }

    /**
     * 改
     *
     * @param information
     * @return
     */
    @Override
    public int update(Information information) {
        return informationMapper.update(information);
    }

    /**
     * 查单
     *
     * @param id
     * @return
     */
    @Override
    public Information get(int id) {
        return informationMapper.get(id);
    }

    /**
     * 查多
     *
     * @return
     */
    @Override
    public List<InformationExtend> list() {
        return informationMapper.list();
    }

    /**
     * 按条件查多
     *
     * @param map
     * @return
     */
    @Override
    public List<InformationExtend> list(Map<String, String> map) {
        return informationMapper.list(map);
    }

    /**
     * 返回最大的Uid
     *
     * @return
     */
    @Override
    public int maxUid() {
        return informationMapper.maxUid();
    }
}
