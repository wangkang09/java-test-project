package com.wangkang.rmi;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:45 2019/6/26
 * @Modified By:
 */

public class Student implements Serializable {
    //private static final long serialVersionUID = 42L;//当远程传输该对象时，必须声明这个，不然会出现序列化出错的问题
    private int id;
    private String name;

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

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
