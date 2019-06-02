package com.wangkang.test.Java类初始化执行顺序测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:57 2019/6/1
 * @Modified By:
 */
public class 子类 extends 父类{

    {
        System.out.println("子类的实例块");
    }
    public 子类() {
        System.out.println("子类的构造方法");
    }
    static {
        System.out.println("子类的静态块");
    }
    //测试 static final 什么时候赋值
    public static final String CONST = staticFinalSub();
    public static final String CON = "String";

    private static String staticStr = getStaticStr();
    public static String str1 = "str";
    private String str = getStr();
    private static String getStaticStr() {
        System.out.println("子类的静态属性初始化");
        return null;
    }
    private String getStr() {
        System.out.println("子类的实例属性初始化");
        return null;
    }
    public static void main(String[] args) {
        new 子类();
        System.out.println("--------------------");
        new 子类();

//        System.out.println("--------");//测试类初始化条件，只要运行main函数就初始化其对应的类
    }

    public static String staticFinalSub() {
        System.out.println("子类 static final 方法");
        return "子类 Static Final";
    }
}
