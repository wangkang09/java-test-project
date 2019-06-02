package com.wangkang.test.枚举测试;

import org.junit.Test;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 15:07 2019/6/1
 * @Modified By:
 */
public class EnumTest {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            //ordinal()：返回一个int值，代表实例声明顺序，从0开始
            System.out.println(s+ " ordinal: "+ s.ordinal());
            //枚举类实现了 Comparable 接口
            System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.println(s.equals(Shrubbery.CRAWLING)+ " ");
            //比较枚举类实例，编译器会自动为你提供 equals()、hashCode() 方法，同时实现了 Serializable 接口
            System.out.println(s == Shrubbery.CRAWLING);
            //通过 getDeclaringClass() 方法，可以知道其所属的枚举类
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("--------------------");
        }
        System.out.println();
        System.out.println();
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class,s);
            System.out.println(shrub);
        }
    }

    @Test
    public void test() {
        System.out.println(Shrubbery.GROUND.getName());
        System.out.println(Shrubbery.CRAWLING.getName());
    }
}
