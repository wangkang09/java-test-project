package com.wangkang.test.Java类初始化执行顺序测试;

import org.junit.Test;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:18 2019/6/2
 * @Modified By:
 */
public class 测试初始化类的条件 {

    @Test
    public void 调用常量() {
        System.out.println(子类.CON);
    }

    @Test
    public void 调用静态变量() {
        System.out.println(子类.str1);
    }

    @Test
    public void 调用静态方法() {
        System.out.println(子类.staticFinalSub());
    }

    @Test
    public void 反射() throws ClassNotFoundException {
        Class.forName("com.wangkang.test.Java类初始化执行顺序测试.子类");
    }

}
