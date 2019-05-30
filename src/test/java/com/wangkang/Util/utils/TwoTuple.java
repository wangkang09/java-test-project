package com.wangkang.Util.utils;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:51 2019/4/4
 * @Modified By:
 */
public class TwoTuple<A,B> {
    //使用private final代替 private 有两个意图
    //1.因为使用元组的意图本来就是返回多个参数，参数的引用是不会变的，所以用final修饰
    //2.这里仍然能够改变参数地址的值，如果后期使get方法返回一个深度拷贝的对象就实现了对象安全
    private final A first;
    private final B second;
    public TwoTuple(A a,B b) {first = a; second = b;}

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
