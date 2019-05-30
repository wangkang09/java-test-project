package com.wangkang.test.线程测试;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:53 2019/4/3
 * @Modified By:
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception {
            create1000Thread();//set有重复的
    }


    private static void create1000Thread() throws Exception {
        Set<String> set = new HashSet<>(102400);

        for (int i = 0; i < 1000000; i++) {
            final String value =   i + " ";//这个变量只能在里面
            Thread t = new Thread() {
                @Override
                public void run() {
                    set.add(value);//因为这里只接受final变量，如果value在for外面则不能使用final修饰
                }
            };

            t.start();
            t.join();

        }

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        if (set.size() != 1000) {
            System.out.println(set.size());
        }
    }
}
