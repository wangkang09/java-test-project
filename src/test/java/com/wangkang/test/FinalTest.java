package com.wangkang.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:01 2019/2/20
 * @Modified By:
 */
/**
 * final修饰类：类不能被扩展</br>
 * final修饰引用变量：变量的地址不能改变</br>
 * final修饰基本类型：基本类型值不能改变</br>
 * 1. 基本包装类都被final修饰了，final修饰包装类型变量，变量赋值后，值不能改变——testBaseWrap</br>
 * 2. final修饰基本类型变量，变量赋值后，值不能改变——testBase</br>
 * 3. final修饰没用final修饰的类时，只是地址不能改变</br>
 */
public class FinalTest {

    @Test
    public void testBaseWrap() {
        final Integer a = 1;
        //a = 2; //也可以看作是值不能改变
    }

    @Test
    public void testBase() {
        final int a = 1;
        //a = 2; //其实是地址不能改变
    }

    @Test
    public void testRef() {
        final List<String> list = Arrays.asList("a","b");
        list.add("c");
        //list = new ArrayList<>();//地址不能改变
    }
}
