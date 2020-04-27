package com.laosun.pojo;

/**
 * @author SUN
 * @version V1.0
 * @data 2020.04.24
 * 对应数据库的information表
 */
public class Information {
    /**
     * id 自增ID
     * uid 用户id
     * name 姓名
     * placeid 籍贯id
     * salary 薪水
     */
    protected int id;
    protected int uid;
    protected String name;
    protected int placeid;
    protected float salary;

    /**
     * 构造方法，id自增不需要传入
     * @param uid
     * @param name
     * @param placeid
     * @param salary
     */
    public Information(int uid, String name, int placeid, float salary) {
        this.uid = uid;
        this.name = name;
        this.placeid = placeid;
        this.salary = salary;
    }

    public Information(){

    }

    public Information(int id, int uid, String name, int placeid, float salary) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.placeid = placeid;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", placeid=" + placeid +
                ", salary=" + salary +
                '}';
    }
}
