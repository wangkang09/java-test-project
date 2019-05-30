package com.wangkang.Util.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 19:48 2019/4/5
 * @Modified By:
 */
public class Sets {

    //并集
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    //交集
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    //差集 a-b
    public static <T> Set<T> subset(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    //差集 a-b
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);

        return result;
    }
}
