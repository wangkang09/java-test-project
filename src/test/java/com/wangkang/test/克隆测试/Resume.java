package com.wangkang.test.克隆测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:09 2019/5/30
 * @Modified By:
 */
public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private WorkExperience we;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        //((Resume)o).we = (WorkExperience) we.clone();
        return o;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", we=" + we +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public WorkExperience getWe() {
        return we;
    }

    public void setWe(WorkExperience we) {
        this.we = we;
    }
}
