package com.wangkang.test.集合测试;

import com.wangkang.Util.CollectionUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:02 2019/1/29
 * @Modified By:
 */

/**
 *1. null可以被加入到list中，也可以被遍历出来，且如果都是null属性，list不为空 -- testAddNull</br>
 *2.
 *
 */
public class ArrayListTest {

    @Test
    public void testAddNull() throws Exception {
        List<String> list =  CollectionUtil.createList();
        list.add(null);
        list.add(null);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.toString());

        Assert.assertTrue("list 不为空",CollectionUtils.isEmpty(list));
    }
}
