package com.laosun;

import com.laosun.mapper.InformationMapper;
import com.laosun.mapper.PlaceMapper;
import com.laosun.pojo.Information;
import com.laosun.pojo.InformationExtend;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类，对项目无影响
 * @author SUN
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {
    @Autowired
    InformationMapper informationMapper;
    @Autowired
    PlaceMapper placeMapper;

    @org.junit.Test
    public void getId(){
        try {
            System.out.println(placeMapper.getId("山东"));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("123123");
        }

    }

//    @org.junit.Test
//    public void add(){
//        Information i = new Information(10005, "小钱", 2, 100000);
//        informationMapper.add(i);
//    }

//    @org.junit.Test
//    public void update(){
//        Information i = informationMapper.get(1);
//        i.setSalary(6666);
//        informationMapper.update(i);
//    }
    @org.junit.Test
    public void delete(){

        informationMapper.delete(107);
    }

    @org.junit.Test
    public void list(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("place","北京");
//        map.put("uid","10003");
        List<InformationExtend> is = informationMapper.list();

        for(InformationExtend i : is){
            System.out.println(i);
        }
    }

}
