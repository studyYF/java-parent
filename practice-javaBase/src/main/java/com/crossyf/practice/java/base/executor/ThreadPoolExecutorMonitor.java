package com.crossyf.practice.java.base.executor;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author Created by crossyf.
 * @date 2020/3/13
 * 功能: 线程池监控
 */
public class ThreadPoolExecutorMonitor extends ThreadPoolExecutor {

    private ConcurrentHashMap<String, Date> startTimes;

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                     TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.startTimes = new ConcurrentHashMap<>();
    }

    @Override
    public void shutdown() {
        System.out.println("已经执行的任务数：" + this.getCompletedTaskCount());
        System.out.println("当前线程活跃数：" + this.getActiveCount());
        System.out.println("当前任务数" + this.getTaskCount());
        super.shutdown();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimes.put(String.valueOf(r.hashCode()), new Date());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
        Date finishDate = new Date();
        long diff = finishDate.getTime() - startDate.getTime();
        System.out.println("当前线程" + Thread.currentThread().getName() + "执行时间为" + diff);
        super.afterExecute(r, t);
    }

    public static ExecutorService newCachedThreadPool() {

        return new ThreadPoolExecutorMonitor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new

                SynchronousQueue());

    }

    @Override
    protected void terminated() {
        super.terminated();
    }
    static ExecutorService monitor = ThreadPoolExecutorMonitor.newCachedThreadPool();


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            monitor.execute(new Test());
        }
        monitor.shutdown();

    }

    static class Test implements Runnable {



        @Override
        public void run() {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
