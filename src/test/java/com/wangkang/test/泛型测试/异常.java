package com.wangkang.test.泛型测试;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 21:23 2019/4/8
 * @Modified By:
 */
public class 异常 {
}
interface Processor<T,E extends Exception> {
    void process(List<T> r) throws E;
}

class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>> {
    List<T> processAll() throws E {
        List<T> r = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(r);
        }
        return r;
    }
}

class Failure1 extends Exception {}