package StudyThread.DeadLock;

/**
 * 模拟线程死锁情况，主线程
 */
public class DeadLockAppMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始！");
        AppResources appResources = new AppResources();
//        // 实例化任务
//        Task1 task1 = new Task1(appResources);
//        Task2 task2 = new Task2(appResources);

        // 创建线程
        Thread thread1 = new Thread(new Task1(appResources),"Thread-for-task1");
        thread1.start();
        Thread thread2 = new Thread(new Task2(appResources),"Thread-for-task2");
        thread2.start();

        thread1.join();

        System.out.println("程序结束！");
    }
}
