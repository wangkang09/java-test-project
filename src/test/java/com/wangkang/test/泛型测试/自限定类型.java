package com.wangkang.test.泛型测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 15:32 2019/4/8
 * @Modified By:
 */
public class 自限定类型 {
    public static void main(String[] args) {

    }
}
//class Basic{
//    Basic b;
//    public void set(Basic b){ this.b = b; }
//}
//class SubType extends Basic{
//    SubType b;
//    public void set(SubType b){ this.b = b; }
//}

class Basic<T> {
    T b;
    public void set(T b) {this.b = b;}
}

class SupType extends Basic<自限定类型> {
    @Override
    public void set(自限定类型 b) {
        super.set(b);
    }
}

class SelfBounded<T extends SelfBounded<T>>{}
class E {}
//class B extends SelfBounded<E> {}//这样就不行,因为E不满足 T extends SelfBounded<T> 形式
class B extends SelfBounded<B> {}//可以，B满足T extends SelfBounded<T>形式

class D extends SelfBounded<D> {}
class F extends SelfBounded<D> {}//可以，因为D满足T extends SelfBounded<T> 形式

//class G extends SelfBounded<F> {}//


//-------------------------原生类型，本来就支持协变
//就是简单的继承了 set方法，且任何BascSetter子类型都行
class BascSetter {void set (BascSetter bs){
    System.out.println("bascSet");
}}
class BascExtend extends BascSetter{}
class BascExtend1 extends BascSetter{}
class BascTest {
    void test(BascSetter bs, BascExtend b, BascExtend1 b1) {
        bs.set(bs);
        bs.set(b);
        bs.set(b1);
    }
}

//标准泛型，参数可以是任何类型
class GenericSetter<T> {void set(T arg){
    System.out.println("fu");
}}
class Gsetter extends GenericSetter<Basic> {}
class Gsetter1 extends GenericSetter<Gsetter1> {}
class test{
    void test(GenericSetter gs, Gsetter g, Gsetter1 g1) {
        gs.set(new Object());
        //g.set(gs);
        g.set(null);
    }
}

//
class SelfBoundSetter<T extends SelfBoundSetter<T>> {void set(T arg) {
    System.out.println("基类");
}}
//最关键的就是：参数只能是自身
class Setter extends SelfBoundSetter<Setter> {}
class Setter2 extends SelfBoundSetter<Setter2> {}
class SetterExtend extends Setter {}
class SelfBoundingAndCovariantArg{
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs,Setter2 setter2,SetterExtend se) {
        s1.set(s2);
        //set (com.wangkang.test.泛型测试.Setter) in SelfBoundSetter cannot be applied to (com.wangkang.test.泛型测试.SelfBoundSetter)
        //s1.set(sbs);
        //setter2.set(sbs);
        setter2.set(setter2);

        s1.set(se);//也可以是子类

        sbs.set(s1);
        sbs.set(s2);
        sbs.set(setter2);
    }
}

