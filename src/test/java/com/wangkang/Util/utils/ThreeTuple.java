package com.wangkang.Util.utils;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:53 2019/4/4
 * @Modified By:
 */
public class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
    private final C thrid;
    public ThreeTuple(A a, B b, C c) {
        super(a,b);
        thrid = c;
    }

    public C getThrid() {
        return thrid;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "thrid=" + thrid +
                '}';
    }
}