package com.crossyf.practice.java.base.executor;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author Created by crossyf.
 * @date 2020/3/13
 * 功能:
 */
public class ExecutorDemo implements Callable {
//    @Override
//    public void run() {
//        try {
//            sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName());
//    }

    //newFixedThreadPool方法会调用 ThreadPoolExecutor(nThreads, nThreads,
    //                                      0L, TimeUnit.MILLISECONDS,
    //                                      new LinkedBlockingQueue<Runnable>());
    //方法，表示会创建一个核心线程数为3，最大线程数也为3，存活时间为0，并将等待的任务放在LinkedBlockingQueue队列中的ThreadPoolExecutor
    //阻塞队列的容量无限大，可以一直添加任务
    //用于负载比较大的服务器，为了资源的合理利用，需要设置线程的最大数量
    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    //线程池的容量无限大，有任务就去线程池中获取空闲的线程，每个空闲的线程最多存活60秒，没有空闲就会创建一个线程
    static ExecutorService executorService2 = Executors.newCachedThreadPool();
    static ExecutorService executorService3 = Executors.newScheduledThreadPool(3);
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,
            60, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
//            executorService.execute(new ExecutorDemo());
//            executor.execute(new ExecutorDemo());
            Future<?> future = executor.submit(new ExecutorDemo());
            try {
                System.out.println("结果+ "+ future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    @Override
    public Object call() throws Exception {
        try {
            sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        return "hello world";
    }
}
