package com.wangkang.test.枚举测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 15:07 2019/6/1
 * @Modified By:
 */
public enum  Shrubbery implements IEnumtest{
    GROUND("ground",11){
        public void abstractMethod() {
            System.out.println("ground");
        }
        public String getName() {
            System.out.println("覆盖了方法");
            return "ground00";
        }
    }, CRAWLING("crawling",12){
        public void abstractMethod() {
            System.out.println("crawling");
        }
    }, HANGING("hanging",13){
        public void abstractMethod() {
            System.out.println("hanging");
        }
    };
    private String name;
    private Integer age;
    Shrubbery(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println("枚举类的实例方法！");
        return name;
    }
    public static void staticMethod() {
        System.out.println("枚举类中的静态方法！");
    }
    public abstract void abstractMethod();

    @Override
    public void interfaceMethod() {
        System.out.println("这个是枚举类实现的接口！");
    }
}
