package com.laosun.pojo;

import org.springframework.stereotype.Component;

/**
 * 此类是Information的扩展，为了显示place而不是placeid
 * @author SUN
 * @version V1.0
 * @date 2020.04.26
 */
@Component
public class InformationExtend extends Information {
    /**
     * 成员变量：地名
     * 还有从父类继承的
     */
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "InformationExtend{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", salary=" + salary +
                '}';
    }
}
