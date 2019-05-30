package com.wangkang.Util.utils;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 18:58 2019/4/5
 * @Modified By:
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        Generator<String> gen = BasicGenerator.create(String.class);

        for (int i = 0; i < 5; i++) {
            gen.next();
        }
    }
}
