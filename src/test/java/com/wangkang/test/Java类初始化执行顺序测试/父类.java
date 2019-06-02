package com.wangkang.test.Java类初始化执行顺序测试;


/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:55 2019/6/1
 * @Modified By:
 */
public class 父类 {
    private String str = getStr();
    {
        System.out.println("父类的实例块");
    }
    public 父类() {
        System.out.println("父类的构造方法");
    }
    private static String staticStr = getStaticStr();
    //测试 static final 修饰的变量赋值时间
    public static final String CONST = "父类staticfinal";
    public static final String CONS = staticFinalSup();
    static {
        System.out.println("父类的静态块");
    }
    private static String getStaticStr() {
        System.out.println("父类的静态属性初始化");
        return null;
    }
    private String getStr() {
        System.out.println("父类的实例属性初始化");
        return null;
    }

    private static String staticFinalSup() {
        System.out.println("父类 static final 方法");
        return "父类 Static Final";
    }
}
