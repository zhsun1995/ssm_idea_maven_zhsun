package com.laosun.pojo;

/**
 * @author SUN
 * @version V1.0
 * @date 2020.04.24
 * 对应native_place表
 */
public class Place {
    /**
     * id 籍贯编号
     * name 籍贯名
     */
    private int id;
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
