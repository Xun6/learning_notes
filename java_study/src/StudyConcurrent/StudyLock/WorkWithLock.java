package StudyConcurrent.StudyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 学习concurrent 中的锁 （Lock）
 */
public class WorkWithLock implements Runnable{
    //TODO ReentrantLock 顾名思义，就是可以重复进入的锁，一个线程获取到锁之后，可以再一次的获取锁，ReentrantLock只是给他来个计数而已（进入加一，退出减一）。而第一次没有获取锁的线程，则无法进入锁
    //TODO Lock锁的操作类似于 synchronized 关键字的功能
    private Lock lock; //定义引用变量
    //构造方法
    public WorkWithLock(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            // TODO 尝试获取锁，可以加等待时间
            try{
                //尝试获取锁，并设备最大等待时间
                if(lock.tryLock(1, TimeUnit.SECONDS)){
                    //TODO 必须再用 try-finally 确保可以 release 锁
                    try {
                        printLockStatus("start");
                        process1();
                    } finally {
                        lock.unlock();
                        printLockStatus("finished");
                    }
                } else{
                    pirntLockFailure();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pirntLockFailure() {
        System.out.println(Thread.currentThread().getName() + " failed to get lock! ");
    }

    //记录线程的名字，阶段，重复获取锁的次数
    private void printLockStatus(String phase) {
        System.out.println("Thread：" + Thread.currentThread().getName() + " " + phase +
                " hold count = " + ((ReentrantLock)lock).getHoldCount()); // 强制类型转换
    }

    // 模拟过程1
    private void process1(){
        try {
            // TODO try的第一行是 lock
            lock.lock();
            printLockStatus("process1");
            process2();
        } finally {
            // TODO 一定要在finally 里第一行 unlock
            lock.unlock();
            printLockStatus("process1 finish");
        }
    }

    // 模拟过程2
    private void process2() {
        try{
            lock.lock();
            printLockStatus("process2");
            process3();
        } finally {
            lock.unlock();
            printLockStatus("process2 finish");
        }
    }

    // 模拟过程3
    private void process3() {
        try{
            lock.lock();
            printLockStatus("process3");
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            printLockStatus("process3 finish");
        }

    }
}
