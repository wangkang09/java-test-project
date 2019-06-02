package com.wangkang.test.枚举测试;

import java.util.EnumSet;
import static com.wangkang.test.枚举测试.Weather.*;
/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:03 2019/6/1
 * @Modified By:
 */
public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<Weather> none = EnumSet.noneOf(Weather.class);
        EnumSet<Weather> all = EnumSet.allOf(Weather.class);
        EnumSet<Weather> mon = EnumSet.of(下雨,刮风);
        EnumSet<Weather> tue = EnumSet.range(雾霾,微风);
        EnumSet<Weather> wed = EnumSet.complementOf(tue);

        System.out.println("none: "+none);//[]
        System.out.println("all: "+all);//[刮风, 晴天, 下雨, 下雪, 雾霾, 闪电, 微风]
        System.out.println("mon: "+mon);//[刮风, 下雨]
        System.out.println("tue: "+tue);//[雾霾, 闪电, 微风]
        System.out.println("wed: "+wed);//[刮风, 晴天, 下雨, 下雪]
    }
}
