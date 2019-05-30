package com.wangkang.test.泛型测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 13:39 2019/4/6
 * @Modified By:
 */
public class GenericTest {}

//因为擦除导致的不能使用T作实际类型
class Erased<T extends Person> {
    public void test() {
        //T t = new T(); errordao
        T t = (T)new Person();
        String arg = "";
        //if (arg instanceof T){};error
        //T[] ts = new T[2];error

        T[] array = (T[]) new Object[1];
        T[] array1 = (T[]) new Person[1];
    }
}
class Person {}

class Building {}
class House extends Building {}

class ClassTypeCapture<T> {
    Class<T> type;
    T t;

    public ClassTypeCapture(Class<T> type) {
        this.type = type;
    }
    public boolean f(Object arg) {
        return type.isInstance(arg);
    }

    public T createInstance() {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //前后两个参数，必须完全一样，不然出错
        ClassTypeCapture<Building> ctt = new ClassTypeCapture<>(Building.class);
        ctt.f(new Building());//ture
        ctt.f(new House());//ture
        ClassTypeCapture<House> ctt1 = new ClassTypeCapture<>(House.class);
        ctt1.f(new Building());//false
        ctt1.f(new House());//ture
    }
}
