package com.wangkang.test.多线程测试;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:51 2019/6/30
 * @Modified By:
 */
public class Sleep_yield_wait_join的区别 {
    private byte[] lock = new byte[0];//使用一个0长度的byte数组做所锁对象最实惠
    volatile boolean  flag = Boolean.TRUE;

    public static void main(String[] args) throws InterruptedException {
        Sleep_yield_wait_join的区别 my = new Sleep_yield_wait_join的区别();
//        my.调用interrupt后线程的中断状态();
//        my.中断一个非活动线程没有任何效果();
//        my.调用sleep线程的运行状态和锁释放情况();
//        my.调用sleep被中断后的状态();
  //      my.先调用interrupt后调用sleep();
  //     my.调用join方法线程完了才会往下走();
//        my.yield声明让出CPU但可能继续执行();
       my.调用wait方法后线程的状态();

    }

    /***
     *  @Description: 调用 sleep 方法后线程进入 Time_Waiting 状态，且不会释放锁
     */
    public void 调用sleep线程的运行状态和锁释放情况() throws InterruptedException {
        Thread sleepTheard = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " 的状态是：" + Thread.currentThread().getState().toString());
            try {
                synchronized (lock) {
                    System.out.println("获取锁了");
                    Thread.sleep(5000);
                    System.out.println("释放锁了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"sleepThread");
        sleepTheard.start();

        Thread.sleep(1000);
        System.out.println(sleepTheard.getName() + " 的状态是：" + sleepTheard.getState().toString());

        synchronized (lock) {
            System.out.println("才进入");
        }
        System.out.println(sleepTheard.getName() + " 的状态是：" + sleepTheard.getState().toString());
    }

    /**
     * @Description: 调用sleep方法后，线程如果被中断，会抛出异常，并清除中断状态
     */
    public void 调用sleep被中断后的状态() throws InterruptedException {
        Thread sleepThread = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程被中断抛异常后是否是中断状态：" + Thread.currentThread().isInterrupted());
            }
        });

        sleepThread.start();
        Thread.sleep(200);
        sleepThread.interrupt();
    }

    /**
     * @Description: 中断一个非活动线程没有任何效果！
     */
    public void 中断一个非活动线程没有任何效果() throws InterruptedException {
        Thread sleepThread = new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("线程运行了");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程被中断抛异常后是否是中断状态：" + Thread.currentThread().isInterrupted());
            }
        });

        sleepThread.interrupt();
        System.out.println("线程被中断后是否是中断状态：" + sleepThread.isInterrupted());

        sleepThread.start();
        Thread.sleep(2000);
    }

    /**
     * @Description: 调用interrupt后线程为中断状态
     */
    public void 调用interrupt后线程的中断状态() throws InterruptedException {
        Thread sleepThread = new Thread(()->{
            while (flag) {}
        });

        sleepThread.start();
        Thread.sleep(200);
        sleepThread.interrupt();
        System.out.println("调用interrupt后线程是否是中断状态：" + sleepThread.isInterrupted());
        flag = Boolean.FALSE;
    }

    public void 先调用interrupt后调用sleep() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("线程被中断抛异常后是否是中断状态：" + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(1000);

        t1.interrupt();
        System.out.println("线程t1中断状态为：" + t1.isInterrupted());

        flag = Boolean.FALSE;
        Thread.sleep(2000);
    }
    public void waitTest() {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void 调用join方法线程完了才会往下走() throws InterruptedException {
       Thread t =  new Thread(() -> {
           try {
               Thread.sleep(40000);
               System.out.println("0");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(1);
        });
       t.start();
       t.join();
        System.out.println("1");

    }

    public void yield声明让出CPU但可能继续执行() {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread.yield();
                System.out.print("1 ");
            }        });
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread.yield();
                System.out.print("2 ");
            }
        });
        t1.start();
        t2.start();
        // 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1 1 2 2 2 2 2 1 1 1 1 1 1 1 ,说明确实让出CPU了（有一段特别规律），但可能继续执行（有一点整个都是一个线程的值）
    }


    public void 调用wait方法后线程的状态() throws InterruptedException {
        Thread waitThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 调用 wait 方法之间的状态是：" + Thread.currentThread().getState().toString());
                    lock.wait(2000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"waitThread");
        waitThread.start();
        Thread.sleep(1000);
        System.out.println(waitThread.getName() + " 调用 wait 方法之后的状态是：" + waitThread.getState().toString());
        Thread.sleep(2000);
        System.out.println(waitThread.getName() + " 调用 wait 方法之后的状态是：" + waitThread.getState().toString());
        System.exit(0);

    }


}
