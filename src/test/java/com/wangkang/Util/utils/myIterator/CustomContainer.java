package com.wangkang.Util.utils.myIterator;

import java.util.Iterator;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 17:10 2019/4/5
 * @Modified By:
 */
public class CustomContainer<T> implements Iterable<T>{

    private T[] data;
    public CustomContainer() {

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private final class MyIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
