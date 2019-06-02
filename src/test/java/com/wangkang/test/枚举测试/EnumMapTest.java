package com.wangkang.test.枚举测试;

import java.util.EnumMap;
import java.util.Map;

import static com.wangkang.test.枚举测试.Weather.*;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:57 2019/6/2
 * @Modified By:
 */
public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Weather,Command> em = new EnumMap(Weather.class);
        em.put(下雪,()->{
            System.out.println("下雪啦！");
        });
        em.put(刮风,()->{
            System.out.println("刮风啦！");
        });
        for (Map.Entry<Weather, Command> entry : em.entrySet()) {
            System.out.print(entry.getKey()+": ");
            entry.getValue().action();
        }

        em.get(闪电).action();
    }
}
interface Command {void action();}