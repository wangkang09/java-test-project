package com.wangkang.Util;

import java.util.*;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:02 2019/1/29
 * @Modified By:
 */
public class CollectionUtil {

    /**
     *
     * @Description: 创建一个list
     * @auther: wangkang
     * @date: 16:05 2019/1/29
     *
     */
    public static <T> List<T> createList(int num) throws Exception {
        if (num < 1) throw new Exception("初始大小 num 小于 1！");
        List<T> list = new ArrayList<>(num);
//        list.iterator();
//        List l = new LinkedList();
//        Set s = new HashSet();//使用Map的iterator
        return list;
    }

    /**
     *
     * @Description: 创建一个list
     * @auther: wangkang
     * @date: 16:05 2019/1/29
     *
     */
    public static <T> List<T> createList() throws Exception {
        return createList(1);
    }

    public static void main(String[] args) {
        Map<Person,Integer> mm = new HashMap<>();
        Person p = new Person(1,"ww");
        mm.put(p,1);
        p = new Person(11,"www");
        mm.put(p,11);
        Iterator<Map.Entry<Person,Integer>> it1 = mm.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry entry = it1.next();
            entry.getKey();

        }

        System.out.println(mm.entrySet());

        Set<Map.Entry<Person,Integer>> en = mm.entrySet();




        List l = new LinkedList();
        l.add("a");
        l.add("b");
        Iterator it = l.iterator();
        while (it.hasNext()) {
            it.next();
        }

        Map<String,String> m = new HashMap();


        for (String s : m.keySet()) {

        }
        for (String s : m.values()) {

        }
        for (Map.Entry<String, String> entry : m.entrySet()) {
            entry.getKey();

        }

        Iterator<Map.Entry<String,String>> it11 = m.entrySet().iterator();
        while (it11.hasNext()) {
            Map.Entry entry = it11.next();
            entry.getKey();

        }
    }

    private static class Person {
        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {

            return 1;
        }
    }

}
