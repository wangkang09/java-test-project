package com.wangkang.Util.utils;

import java.lang.reflect.Array;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 14:36 2019/4/6
 * @Modified By:
 */
public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type,size);//这样实际类型就是type（T）了！
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {//返回的类型就是type类型
        return array[index];
    }

    public T[] rep() {return array;}//返回的就是type数组，因为创建的实际类型就是type类型

    public static void main(String[] args) {
        GenericArray<Integer> ga = new GenericArray<>(Integer.class,5);

        //integer数组可以转换为object数组
        Integer[] ints = new Integer[3];
        Object[] o = new Object[3];
        //o = ints;//o为integer类型了,成功
        o[1] = new Integer(1);

        //object数组不可以转换为integer数组
        Object[] oo = new Object[3];
        Integer[] ints1 = new Integer[3];
        //ints1 = oo;//required Integer[] found Object[]

        try {
            ints1 = (Integer[]) oo;//required Integer[] found Object[]
        } catch (Exception e) {
            System.out.println("Object的数组不能强转换为Integer数组");
        }

        //任何数组都可以被通过Object数组指针指向
        GenericArray[] ge = new GenericArray[3];
        o = ge;

        try {
            ints1 = (Integer[])oo;//不能强转！运行时报错
        } catch (Exception e) {
            System.out.println("不能强转！");
        }

        Object a = ga.get(0);//同样
        Integer aa = ga.get(0);//成功，说明可以强转
        o = ga.rep();//同样
        Integer[] ia = ga.rep();//这里rep返回的还是Object类型，只能说明运行时，因为类型标签，而强转成功；因为array的实际类型就是Interger数组，才能转换。
        //Object[] 是无法转换为 Integer[] 的 因为想要强制转换他们必须具有父子关系，虽然Object是所有类型的父类，但是java数组时对象，Object[] 是另外一个类了，它并不是Integer[] 的父类
    }
}

class GenericArray0<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray0(int size) {
        array = (T[]) new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {return array[index];}//这里返回的是Object

    public T[] rep() {return array;}//这里返回的是Object数组，实际类型擦除了
    public static void main(String[] args) {
        GenericArray0<Integer> ga = new GenericArray0<>(5);
        ga.put(0,1);
        //ga.get(0)返回的是Object类型 // Method get:(I)Ljava/lang/Object;
        //说明可以强转
        Integer a = ga.get(0);//这个为什么不报错！ -> 编译器自动转了checkcast#10class java/lang/Integer
        Object[] o = ga.rep();//integer[] -> object[] 成功

        try {
            Integer[] ia = ga.rep();//[Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        } catch (Exception e) {
            //checkcast // class "[Ljava/lang/Integer;" 上面是编译成功，转型失败
            System.out.println("因为擦除了类型信息，导致不能强转！");
        }

    }
}

class GenericArray1<T> {
    private Object[] array;
    public GenericArray1(int size) {array = new Object[size];}
    public void put(int index, T item) { array[index] = item;}
    public T get(int index) {return (T) array[index];}
    public T[] rep() {return (T[]) array;}
    public Object getObj(int index) {return array[index];}

    public static void main(String[] args) {
        GenericArray1<Integer> g1 = new GenericArray1(3);
        g1.put(0,1);
        //编译就不通过了！
        //Integer in = g1.getObj(0);//这里出问题了，证明Object不能转Integer
        Integer in = (Integer)g1.getObj(0);//说明可以强转！因为是引用指向，所以可以强转！
        Integer in1 = g1.get(0);//进一步证明可以强转，这里没出问题，说明，get方法的时候，已经转成Integer了

        Object obj = in1;//任何类型都可以被Object的变量指向
        int a = 1;
        obj = a;

        Integer[] temp = {1,2,4,6};
        Object[] objs = temp;//只是引用指向
        Integer[] ins = (Integer[]) objs;//可以强制转换

        Object[] ins1 = {1,2,4,6};//这个是赋值
        try {
            ins = (Integer[]) ins1;
        } catch (Exception e) {
            System.out.println("不能强制转换！");
        }

        try {
            Integer[] is = g1.rep();
        } catch (Exception e) {
            System.out.println("类型被参数，不能强转！");
        }


    }
}