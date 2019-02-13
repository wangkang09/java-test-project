package com.wangkang.test;

import org.junit.Test;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:30 2019/1/30
 * @Modified By:
 */
/**
 * 1. null.equals 会报空指针; obj.equals(null)始终返回false
 *
 */
public class EqualsTest {

    @Test
    public void nullEqualsObjtest() {
        String str = null;

        System.out.println("1".equals(str));
        System.out.println(str.equals("1"));

    }
}
