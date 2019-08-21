package com.wangkang.test.volatile测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:00 2019/7/10
 * @Modified By:
 */
public class VolatileUser {
    private volatile int age;
    private int[] aint = new int[1024*1024*100];
    private String name;

    public int[] getAint() {
        return aint;
    }

    public void setAint(int[] aint) {
        this.aint = aint;
    }

    public VolatileUser(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
