package StudyConcurrent.StudyLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 学习 lock 对标 wait notify
 */
public class LearnLockWaitNotifyAppMain {
    public static void main(String[] args) throws InterruptedException {
        Lock locker = new ReentrantLock(); //无所谓公平锁，缺省即可
        Condition condition = locker.newCondition();
        int workingSec = 2;
        int threadCount =3;
        //创建三个线程
        for (int i =0; i < threadCount; i++){
            new Thread(() ->{
                System.out.println(getName() + ": 线程开始工作... ...");
                try{
                    locker.lock();
                    sleepSec(workingSec);
                    System.out.println(getName() + "进入等待");
                    // TODO await 方法必须在当前线程获取锁之后才能调用，调用后，自动失去锁
                    condition.await();
                    // TODO 被唤醒的线程，就相当于执行过了 await 方法，开始往下执行，指定的第一件事就是获取之前失去的锁
                    System.out.println(getName() + "线程继续执行... ...");
                    sleepSec(2);
                    System.out.println(getName() + "结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    locker.unlock(); // 解锁
                }
            },"工作线程" + i).start();
        }

        // >>TODO  await / signal 一样也有lost notification 的问题
        System.out.println("----------唤醒线程开始sleep-----------");
        sleepSec(workingSec + 1);
        System.out.println("----------唤醒线程sleep结束-----------");
        try{
            locker.lock();
            // TODO signal / signalAll 方法必须在当前线程获取锁之后才能调用
            System.out.println("-----------开始唤醒所有------------");
            condition.signalAll();
            // 或者逐个唤醒
//            for (int i =0; i < 3; i++){
//                System.out.println("----------开始逐个唤醒-----------");
//                condition.signal();
//            }
        } finally {
            locker.unlock();
        }
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }

    private static void sleepSec(int waitTime) throws InterruptedException {
        Thread.sleep(waitTime);
    }
}

