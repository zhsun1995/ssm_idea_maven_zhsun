package com.laosun.mapper;

import com.laosun.pojo.Information;
import com.laosun.pojo.InformationExtend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author SUN
 * @version V1.0
 * @date 2020.04.24
 */
public interface InformationMapper {
    /**
     * 简单的SQL直接用注解完成
     */

    /**
     * 增
     * @param information
     * @return
     */
    @Insert("insert into information(uid,name,placeid,salary) values (#{uid},#{name},#{placeid},#{salary})")
    public int add(Information information);

    /**
     * 删
     * @param uid
     * @return
     */
    @Delete("delete from information where uid = #{uid}")
    public void delete(int uid);

    /**
     * 改
     * @param information
     * @return
     */
    @Update("update information set name = #{name}, " +
            "placeid = #{placeid}, salary = #{salary} where uid = #{uid}")
    public int update(Information information);

    /**
     * 查单
     * @param id
     * @return
     */
    @Select("select * from information where id = #{id}")
    public Information get(int id);

    /**
     * 两个查多函数利用配置文件写动态sql语句
     * Informatiom.xml  放于同目录下
     */
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
    @Select("select max(uid) from information")
    public int maxUid();
}
