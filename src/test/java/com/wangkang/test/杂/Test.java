package com.wangkang.test.杂;

import java.util.concurrent.ThreadLocalRandom;

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
//        Test t = new Test();
//        t.test();
        int flag = 524288;
        Long max = 0L;
        for (int i = 0; i < flag; i++) {
            Long value = ThreadLocalRandom.current().nextLong(2L<<32);
            int j = 1;
            for (; j < 32; j++) {
                if (value >> j << j != value) {
                    System.out.println(j);
                    System.out.println(value);
                    if (j > max) {
                        max = (long)j;
                    }
                    break;
                }
            }
        }
        System.out.println(max);
        System.out.println(2<<(max-1));
        System.out.println(Math.log(flag)/ Math.log(2));
    }


}
