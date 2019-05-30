package com.wangkang.test.杂;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 18:38 2019/4/5
 * @Modified By:
 */
public class New {
    public static <K,V> Map<K,V> map() {
        return new HashMap<K,V>();
    }
    public <T> List<T> list() {
        return new ArrayList<T>();
    }
    public void test() {
        New.<String,String>map();
        this.<String>list();
    }

    public static void main(String[] args) {
        New n = new New();
        n.test();
    }
}
