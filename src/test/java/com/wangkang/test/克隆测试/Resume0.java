package com.wangkang.test.克隆测试;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:13 2019/5/31
 * @Modified By:
 */
public class Resume0 implements Cloneable,Serializable {
    private String name;
    private String sex;
    private String age;
    //private List<WorkExperience> wks;

    private WorkExperience[] wks;


    //列表形式
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Resume0 o = (Resume0) super.clone();
//        o.wks = new ArrayList<>(wks.size());//列表不能直接克隆，关键是这一步，如果没有这一步，新旧两个对象的 wks 对应的地址是一样的，这样后面再怎么变化其中任何一个对象中的值，另一个对象也会跟着变
//        for (int i = 0,iMax = wks.size(); i < iMax; i++) {
//            o.wks.add((WorkExperience) wks.get(i).clone());
//        }
//        return o;
//    }
//    @Override
//    public String toString() {
//        return "Resume0{" +
//                "name='" + name + '\'' +
//                ", sex='" + sex + '\'' +
//                ", age='" + age + '\'' +
//                ", wks=" + wks +
//                '}';
//    }


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

//    public List<WorkExperience> getWks() {
//        return wks;
//    }
//
//    public void setWks(List<WorkExperience> wks) {
//        this.wks = wks;
//    }
//
//    public void addWks(WorkExperience wk) {
//        this.wks.add(wk);
//    }

    @Override
    public String toString() {
        return "Resume0{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", wks=" + Arrays.toString(wks) +
                '}';
    }

    public void setWks(WorkExperience[] wks) {
        this.wks = wks;
    }
    public WorkExperience[] getWks() {
        return wks;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume0 o = (Resume0) super.clone();
        WorkExperience[] ss = new WorkExperience[wks.length];
        o.wks = wks.clone();
        for (int i = 0,iMax = wks.length; i < iMax; i++) {
            o.wks[i] = (WorkExperience) wks[i].clone();
        }
        return o;
    }
}
