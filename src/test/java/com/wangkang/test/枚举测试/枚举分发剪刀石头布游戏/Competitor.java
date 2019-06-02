package com.wangkang.test.枚举测试.枚举分发剪刀石头布游戏;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 12:33 2019/6/2
 * @Modified By:
 */
public interface Competitor<T extends Comparable<T>> {
    结果 compete(T competitor);
}
