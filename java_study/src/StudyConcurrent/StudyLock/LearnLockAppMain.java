package StudyConcurrent.StudyLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 学习 concurrent包中的锁
 */
public class LearnLockAppMain {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        WorkWithLock workWithLock = new WorkWithLock(lock);
        // 创建三个线程
        for (int i=0; i<3; i++){
            Thread thread = new Thread(workWithLock,"Work-"+i);
            thread.start();
        }
    }
}
