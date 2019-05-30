package com.wangkang.test.锁测试;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 10:47 2019/5/5
 * @Modified By:
 */
public class 读写锁 {
    static ReadWriteLock lock = new ReentrantReadWriteLock();

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,500,20,TimeUnit.SECONDS,new SynchronousQueue<>());
    public static void main(String[] args) {
        //多个读请求拿到读锁
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 480; i++) {
                threadPoolExecutor.execute(()->{
                    lock.readLock().lock();
                    System.out.println(Thread.currentThread().getName()+ "：获取读锁");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.readLock().unlock();
                        System.out.println(Thread.currentThread().getName()+ "：释放读锁");
                    }

                });

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        t2.start();
        //一个写请求去拿写锁
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       Thread t = new Thread(()->{
           System.out.println("开始获取写锁。");
            lock.writeLock().lock();
            try {
                System.out.println("获取到写锁。");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
                System.out.println("释放写锁。");
            }
        });
        t.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();

    }
}
