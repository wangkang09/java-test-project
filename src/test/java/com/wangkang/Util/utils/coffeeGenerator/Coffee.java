package com.wangkang.Util.utils.coffeeGenerator;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 12:15 2019/4/4
 * @Modified By:
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                '}';
    }
}
