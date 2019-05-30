package com.wangkang.Util.utils;

/**
 * @Description:  先进先出，头插法
 * @Author: wangkang
 * @Date: Created in 11:55 2019/4/4
 * @Modified By:
 */
public class LinkedStack<T> {
    private static class Node<U> { //静态内部类不能获取泛型类的参数类型
        U item;
        Node<U> next;
        Node() {item = null; next = null;}
        Node(U item, Node<U> next) {this.item = item; this.next = next;}
        boolean end() {return item == null && next == null;}
    }
    private Node<T> top = new Node<T>();
    public void push(T item) {top = new Node<T>(item,top);}
    public T pop() {
        T result = top.item;
        if (!top.end()) top = top.next;
        return result;
    }
    public static void main() {
        LinkedStack<String> lss = new LinkedStack();
        for(String s : "Phasers on stun!".split(" ")) lss.push(s);
        String s;
        while((s = lss.pop()) != null) System.out.println(s);
    }
}