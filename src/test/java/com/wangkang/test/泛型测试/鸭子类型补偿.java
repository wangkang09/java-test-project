package com.wangkang.test.泛型测试;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.wangkang.test.泛型测试.Communicate.perform;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 22:00 2019/4/8
 * @Modified By:
 */
public class 鸭子类型补偿 {
    public static void main(String[] args) {
        perform(new SmartDog());
        perform(new Cat());
        //perform(new Mime());
    }
}

class Mime {
    public void walk(){}
    public void sit(){
        System.out.println("Pretending to sit");
    }
    public void push(){}
    public String toString(){return "Mime";}
}

class SmartDog {
    public void speak(){
        System.out.println("woof!");
    }
    public void sit(){
        System.out.println("sitting");
    }
    public void reproduce(){}
}

class Cat {
    public void speak(){
        System.out.println("cat!");
    }
    public void sit(){
        System.out.println("catSitting");
    }
    public void reproduce(){}
}

class Communicate {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();

        Method speak = null;
        Method sit = null;
        try {
            speak = spkr.getMethod("speak");
            sit = spkr.getMethod("sit");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            sit.invoke(speaker);
            speak.invoke(speaker);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
