package com.wangkang.test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:23 2019/4/8
 * @Modified By:
 */
public class ComparableTest {
    public static void main(String[] args) {
        testComparable();
        testComparator();

    }
    private static void testComparable() {
        MyComparable my = new MyComparable(1);
        MyComparable my1 = new MyComparable(2);

        List<MyComparable> list = Arrays.asList(my,my1);

        Collections.sort(list);

        for (MyComparable myComparable : list) {
            System.out.println(myComparable.getValue());
        }
        System.out.println(my.compareTo(new MyComparable(2)));
    }
    private static void testComparator() {
        MyComparator my = new MyComparator();

        my.reversed();//返回一个MyComparator比较器的镜像比较器
        //返回一个新的比较器，当自身比较器比较为相等时，才调用参数里的比较器，在做一次判断
        //这样可以使用这个方法，多层嵌套，形成多个相等判断比较器
        my.thenComparing(new MyComparator());

        //通过一个T实例，使用keyExtractor得到一个新的T实例
        //得到的2个新的T实例，使用外比较器KeyComparator作比较
        my.thenComparing((k)->{
            String name = k.getName();
            int len = name.length();
            return len;
        },new ExtraComparator());

        //和上个的区别在于，这个直接使用两个返回值的内比较器的compareTo作比较
        my.thenComparing((k)->{
            String name = k.getName();
            int len = name.length();
            return new ExtraComparable(len);
        });
    }
}

class MyComparable implements Comparable<MyComparable> {
    private int value;
    private String name;
    public MyComparable(int value) {
        this.value = value;
    }
    public MyComparable(int value, String name) {
        this.value = value;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    @Override
    public int compareTo(MyComparable o) {
        return -this.value + o.value;
    }
}
class MyComparator implements Comparator<MyComparable> {
    @Override
    public int compare(MyComparable o1, MyComparable o2) {
        return o1.getValue()-o2.getValue();
    }
}

class ExtraComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}

class ExtraComparable implements Comparable<ExtraComparable> {
    private Integer value;
    public ExtraComparable(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    @Override
    public int compareTo(ExtraComparable o) {
        return this.value - o.value;
    }
}