package com.wangkang.test;

import com.wangkang.entity.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 17:17 2019/1/29
 * @Modified By:
 */
/**
 *1. map 可以插入null，且可以被遍历出来 -- testAddNull
 *2. map 为null，遍历会报错 -- foreachNull
 *
 */
public class MapTest {

    @Test
    public void testAddNull() {
        Map<String,String> map = new HashMap<>();

        map.put(null,null);
        map.put("1","1");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
        }
    }

    @Test
    public void foreachNull() {
        Map<String,String> map = null;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
