package com.wangkang.test.继承测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 17:15 2019/4/6
 * @Modified By:
 */
public class FF {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        //Arrays.sort();
        Fruit f = new Apple();
        fruits[0] = new Apple();
        fruits[1] = new AppleExtend();
        fruits[2] = (Apple)new Fruit();
        fruits[3] = new Orange();

        fruits[0] = new Fruit();
    }
}

class Fruit {}

class Apple extends Fruit {}

class AppleExtend extends Apple {}

class Orange extends Fruit {}