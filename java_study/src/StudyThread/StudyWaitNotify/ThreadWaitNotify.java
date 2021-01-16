package StudyThread.StudyWaitNotify;

import java.util.concurrent.TimeUnit;

/**
 * 同步控制之 wait notify
 *
 */
public class ThreadWaitNotify {
    public static void main(String[] args) {
        Object locker = new Object();

        int workingSec = 2;  // 表示工作时间
        int threadCount =5; // 线程数量
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "：线程开始工作... ...");
                try{
                    synchronized (locker){
                        sleepSec(workingSec); // 睡2秒
                        System.out.println(Thread.currentThread().getName() + "：进入等待 ");
                        // TODO wait 方法必须进入相应对象的synchronized块中才能调用
                        // TODO 执行 wait后，自动失去对象的monitor（锁），别的线程可以进入 synchronized代码块
                        locker.wait();

                        //
                        // TODO 被唤醒的线程，相当于执行过了 wait方法，开始向下执行。
                        System.out.println(Thread.currentThread().getName() + "：线程继续... ");
                        sleepSec(workingSec); // 睡2秒
                        System.out.println(Thread.currentThread().getName() + "：结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"工作线程" + i).start();
        }

        // 主线程继续执行
        System.out.println("-----------------唤醒线程开始sleep-------------------");
        sleepSec(workingSec+1);
        System.out.println("--------------------唤醒线程sleep结束---------------------");
        synchronized (locker){
            // TODO notify/notifyAll方法，必须进入相应对象的synchronized代码块中才能调用
//            System.out.println("---------------开始唤醒所有-----------------");
//            locker.notifyAll();

            for (int i=0; i < threadCount; i++){
                System.out.println("--------------开始逐个唤醒----------------");
                locker.notify();
            }
        }
    }

    // 睡几秒
    private static void sleepSec(int i) {
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
