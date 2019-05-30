package com.wangkang.test.杂;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 18:39 2019/4/5
 * @Modified By:
 */
public class Test {
    public void test() {
        New n = new New();
        n.<String>list();
        New.<String,String>map();
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
}
