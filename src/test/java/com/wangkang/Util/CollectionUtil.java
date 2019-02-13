package com.wangkang.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:02 2019/1/29
 * @Modified By:
 */
public class CollectionUtil {

    /**
     *
     * @Description: 创建一个list
     * @auther: wangkang
     * @date: 16:05 2019/1/29
     *
     */
    public static <T> List<T> createList(int num) throws Exception {
        if (num < 1) throw new Exception("初始大小 num 小于 1！");
        List<T> list = new ArrayList<>(num);
        return list;
    }

    /**
     *
     * @Description: 创建一个list
     * @auther: wangkang
     * @date: 16:05 2019/1/29
     *
     */
    public static <T> List<T> createList() throws Exception {
        return createList(1);
    }


}
