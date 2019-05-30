package com.wangkang.Util.utils.coffeeGenerator;

import com.wangkang.Util.utils.Generator;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 12:18 2019/4/4
 * @Modified By:
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class};

    public CoffeeGenerator() {
    }

    private int size = 0;//末端哨兵
    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[ThreadLocalRandom.current().nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count --;
            return CoffeeGenerator.this.next();
        }
    }
}
