package com.wangkang.test.泛型测试;

import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 18:12 2019/4/6
 * @Modified By:
 */
public class 通配符 {}
class Wildcards {
    //这个方法，不管传什么参数，都是对的，原始类型，什么类型都能重新set
    static void rawArgs(Holder holder, Object arg) {
        Object o = holder.getValue();//只能赋值Object类型
        holder.setValue(arg);
        holder.setValue(new Wildcards());
    }
    //这个方法，因为只有get所以什么方法都是对的,唯一注意的就是转型了，而转型和泛型没有关系！
    //它接受所有类型
    static Object unboundedArg(Holder<?> holder, Object arg) {
        //holder.setValue(arg);编译出错，并不能任何值
        Object o = holder.getValue();//只能赋值Object类型
        return o;
    }
    //所有方法都是对的，因为只有get方法，只有运行时转型异常
    static <T> T exact1(Holder<T> holder) {
        T t = holder.getValue();
        return t;
    }
    //传过来的两个参数，**方法参数说明，holder元素的类型是和arg一致的，可能就想是不是只用qualified能成功，其实不对。
    //关键在于：父类的引用能指向子类，这样T为Apple时，holder完全可以为Holder<Fruit>，就holder可以为 Holder<? super Apple>
    //所以Holder<? extends T>和<?>是不能传进来的，因为不能确定里面是否都是arg的父类
    //Holder<? super T>、原生类、Holder<T>可以，因为能保证都是arg的父类
    //且返回值，编译器会自动转型为arg类型！
    //关键的思想就是在父类的引用能指向子类思想的条件下扩充条件，尽一切可能满足条件，实在不能满足那就是编译错误
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setValue(arg);
        T t = holder.getValue();
        return t;
    }
    //传过来的两个参数，**方法参数，？ extends T表示容器中的元素必须是T类型的子类。为了尽量满足它，所以可以是arg先向上转型
    //因为具体泛型类型arg可以无限转型到Object所以，T可以是Object，说明holder中的元素只要是Object类型的子类就行，所以都行
    //且返回值，编译器会自动转型为arg类型！
    //关键的思想就是在父类的引用能指向子类思想的条件下扩充条件，尽一切可能满足条件，实在不能满足那就是编译错误
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //holder.setValue(arg);//编译错误，set(capture of ? extends T) cannot be applied to T
        T t = holder.getValue();
        return t;
    }
    //? super T说明了容器中的元素都必须为T类型的父类！这里就不能让T向上转型了，那会是条件更苛刻
    //这样holder只能是T的父类了，<? extends T>和<?>都不能满足
    //<? super T>、<T>能满足
    //且返回值，编译器会自动转型为arg类型！
    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.setValue(arg);
        //T t = holder.getValue();//编译出错，requried T found capture of ? super T
        Object t = holder.getValue();
    }
    public static void main(String[] args) {
        rawArgstest();
        unboundedArgTest();
        exact1Test();
        exact2Test();
        wildSubtypeTest();
        wildSuperTypeTest();
    }

    //方法参数为原始类型，方法所有类型都可以接收，不报错；因为是get赋值给Object所以没错
    private static void rawArgstest() {
        //Holder raw = new Holder<Long>();//这个Long泛型是没有的，编译时只是Holder原生类
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();
        Holder<? super Long> bounded0 = new Holder<>();
        Long lng = 1L;

        rawArgs(raw,lng);
        rawArgs(raw,new Wildcards());
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);
        rawArgs(bounded0,lng);
    }
    private static void unboundedArgTest() {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();
        Holder<? super Long> bounded0 = new Holder<>();
        Long lng = 1L;

        //方法参数为无界通配符，是可以get的，但get出来类型就消失成object了
        raw = new Holder<>(new Wildcards());
        Wildcards w = (Wildcards) unboundedArg(raw,lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbounded,lng);
        unboundedArg(bounded,lng);
    }
    private static void exact1Test() {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<>();
        Holder<? super Long> bounded0 = new Holder<>();
        Long lng = 1L;

        //方法参数为标准泛型，没有通配符，因为类型擦除，所以只能输出Object类型
        Object r1 = exact1(raw);
        Long r22 = exact1(qualified);//可能运行出错，因为编译器才不知道运行时的类型呢
        Object r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        //Long r4 = exact1(bounded);////可能运行出错，因为编译器才不知道运行时的类型呢
        Object r4 = exact1(bounded);
    }
    //所以Holder<? extends T>和<?>是不能传进来的，因为不能确定里面是否都是arg的父类
    //Holder<? super T>、原生类、Holder<T>可以，因为能保证都是arg的类
    private static void exact2Test() {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Holder<? super Long> bounded0 = new Holder<>();
        Long lng = 1L;

        //方法为一般泛型类型，因为方法里有set，所以无界和没有下界的 unbounded和bounded不能set，所以报错
        Long r5 = exact2(raw,lng);
        Long r6 = exact2(qualified,lng);
        //exact2(qualified,new Wildcards());编译出错，因为类型根本就不匹配！
        //exact2(new Holder<String>(),lng);
        exact2(new Holder<>(),lng);
        exact2(new Holder<Long>(),lng);
        //exact2(unbounded,lng);//编译出错，
        //exact2(bounded,lng);//编译出错，

        exact2(bounded0,lng);
    }
    //所以Holder<? super T>和<?>是不能传进来的，因为不能确定里面是否都是arg的子类
    //Holder<? extends T>、原生类、Holder<T>可以，因为能保证都是arg的子类
    private static void wildSubtypeTest() {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Holder<? super Long> bounded0 = new Holder<>();
        Long lng = 1L;

        //方法为有上界的泛型，因为没有set方法，所以任何参数都没问题，这里没报错是因为，所有的返回值都是null，所以可以转化成Long
        //但是如果赋值时，就会报错
        Long r9 = wildSubtype(raw,lng);
        Long r10 = wildSubtype(qualified,lng);
        Object r11 = wildSubtype(unbounded,lng);
        //Long r111 = wildSubtype(unbounded,lng);//当赋值Long时，编译就出错，
        Long r12 = wildSubtype(bounded,lng);//可能运行出错，因为编译器才不知道运行时的类型呢
        wildSubtype(bounded0,lng);
    }
    private static void wildSuperTypeTest() {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Holder<? super Long> bounded0 = new Holder<>();
        Long lng = 1L;

        wildSuperType(raw,lng);
        wildSuperType(qualified,lng);
        //wildSuperType(unbounded,lng);//编译出错，
        //wildSuperType(bounded,lng);//编译出错，
        wildSuperType(bounded0,lng);
    }

//    public static void printList(List<?> list) {
//        for (Object elem: list)
//            System.out.print(elem + "");
//        System.out.println();
//    }
    public static <T> void printList(List<T> list) {
        for (T elem: list)
            System.out.print(elem + "");
        System.out.println();
    }
}
class Holder<T> {
    private T value;
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Holder(T value) {
        this.value = value;
    }
    public Holder() {}
}

interface Payable<T> {}
class Employee implements Payable<Employee>{}
//class Hourly extends Employee implements Payable<Hourly> {}

class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

//class Cat extends ComparablePet implements Comparable<Cat> {}

