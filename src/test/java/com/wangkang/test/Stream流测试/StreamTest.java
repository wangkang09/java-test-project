package com.wangkang.test.Stream流测试;

import com.wangkang.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:16 2019/1/30
 * @Modified By:
 */
/**
 * 1. filter里对null值进行操作，会报错 -- testFilterIsNull</br>
 * 2. 通过 filter(x->x!=null) 或 filter(Objects::nonNull) 来过滤null值 -- testFilterNull</br>
 * 3. filter功能：取表达式为true的obj，即过滤掉为false的obj -- testFilterObj</br>
 *
 */

public class StreamTest {

    @Test
    //filter里对null值进行操作，会报错
    public void testFilterIsNull() {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","A",null));

        List result = list.stream().filter(x->x.toUpperCase().equals("A")).collect(Collectors.toList());

        System.out.println(result.toString());
    }

    @Test
    //通过 filter(x->x!=null) 或 filter(Objects::nonNull) 来过滤null值
    public void testFilterNull() {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","A",null));
        List result = list.stream().filter(x->x!=null).collect(Collectors.toList());
        System.out.println(result.toString());
        result = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(result.toString());
    }

    @Test
    //filter功能：取表达式为true的obj，即过滤掉为false的obj
    public void testFilterObj() {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","A",null));
        List result = list.stream().filter(x->"A".equals(x)).collect(Collectors.toList());
        System.out.println(result.toString());
    }



}
