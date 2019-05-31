package com.wangkang.test.克隆测试;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:08 2019/5/30
 * @Modified By:
 */
public class 简单对象克隆 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume = new Resume();
        resume.setAge("11");
        resume.setName("wk");
        resume.setSex("男");
        resume.setWe(new WorkExperience("12-16","南京"));

        System.out.println(resume);

        Resume resume1 = (Resume) resume.clone();

        resume1.setSex("女");
        resume1.getWe().setCompany("北京");
        //resume1.setWe(new WorkExperience("12-17","北京"));//如果直接setWe，则肯定不会改变原型对应的值，因为只是改变了resume1中的we的引用
        System.out.println(resume1);
        System.out.println(resume);
    }

    @Test
    public void test() throws CloneNotSupportedException {
        Resume0 resume = new Resume0();
        resume.setAge("11");
        resume.setName("wk");
        resume.setSex("男");
        List<WorkExperience> wks = new ArrayList<>();
        wks.add(new WorkExperience("1-2","nanjing"));
        wks.add(new WorkExperience("2-3","beijing"));
        wks.add(new WorkExperience("3-4","shanghai"));
//        resume.setWks(wks);
//
//        System.out.println(resume);
//
//        Resume0 resume0 = (Resume0) resume.clone();
//        resume0.getWks().get(0).setTimeAArea("11-12");
//
//        System.out.println(resume);
//        System.out.println(resume0);
    }

    @Test
    public void test数组() throws CloneNotSupportedException {
        Resume0 resume = new Resume0();
        resume.setAge("11");
        resume.setName("wk");
        resume.setSex("男");
        WorkExperience[] workExperiences = {new WorkExperience("1-2","nanjing"),new WorkExperience("2-3","beijing")};
        resume.setWks(workExperiences);

        Resume0 resume0 = (Resume0) resume.clone();
        resume0.getWks()[0].setTimeAArea("11-12");
        System.out.println(resume);
        System.out.println(resume0);
    }

    @Test
    public void 序列化() throws IOException, ClassNotFoundException {
        Resume0 resume = new Resume0();
        resume.setAge("11");
        resume.setName("wk");
        resume.setSex("男");
        WorkExperience[] workExperiences = {new WorkExperience("1-2","nanjing"),new WorkExperience("2-3","beijing")};
        resume.setWks(workExperiences);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(resume);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        Resume0 resume0 = (Resume0) objectInputStream.readObject();
        resume0.getWks()[0].setTimeAArea("11-22");

        System.out.println(resume);
        System.out.println(resume0);

    }
}
