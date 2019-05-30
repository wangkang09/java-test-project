package com.wangkang.test;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:42 2019/2/20
 * @Modified By:
 */

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 1. JVM引用诊断：-XX:+PrintReferenceGC
 * 2. 如何在对象没有被强引用时，通知JVM对象正被使用：
 */
public class ReferenceTest {

    @Test
    public void PhantomReference() {
        Object counter = new Object();
        ReferenceQueue ref = new ReferenceQueue();
        PhantomReference<Object> p = new PhantomReference<>(counter,ref);

        counter = null;
        System.gc();
        Reference<Object> re = null;

        try {
            re = ref.remove(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (re !=null) {
            //do something
            System.out.println("re is not null!");
        }
    }


    
}
