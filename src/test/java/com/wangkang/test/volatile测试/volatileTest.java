package com.wangkang.test.volatile测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:02 2019/7/10
 * @Modified By:
 */
public class volatileTest {
    public static void main(String[] args) throws InterruptedException {
        VolatileUser vu = new VolatileUser(25,"wk");
        vu.getAint();
        new Thread(() -> {
            System.out.println("iinru");
            while (vu.getName() == "wk") {}
            System.out.println(vu.getAge());
        }).start();
        vu.setName("kk");
        System.out.println("zu");

    }

    private static void aa() throws InterruptedException {
        VolatileUser vu = new VolatileUser(25,"wk");
        vu.getAint();
        new Thread(() -> {
            while (vu.getName() == "wk") {}
            System.out.println(vu.getAge());
        }).start();
        vu.setName("kk");
    }
}
