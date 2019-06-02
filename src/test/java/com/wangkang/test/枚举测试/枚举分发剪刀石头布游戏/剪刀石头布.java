package com.wangkang.test.枚举测试.枚举分发剪刀石头布游戏;

import static com.wangkang.test.枚举测试.枚举分发剪刀石头布游戏.结果.*;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 12:23 2019/6/2
 * @Modified By:
 */
public enum 剪刀石头布 implements Competitor<剪刀石头布>{
    剪刀(平,输,赢), 石头(赢,平,输), 布(输,赢,平);

    剪刀石头布(结果 a, 结果 b, 结果 c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    private 结果 a,b,c;

    @Override
    public 结果 compete(剪刀石头布 competitor) {
        switch (competitor) {
            default:
            case 剪刀: return a;//如果是剪刀的话，那就是和当前对象的第一个比较
            case 石头: return b;
            case 布: return c;
        }
    }
    public static void main(String[] args) {
        System.out.println(剪刀.compete(石头));
        System.out.println(剪刀.compete(布));
        System.out.println(剪刀.compete(剪刀));
    }
}
