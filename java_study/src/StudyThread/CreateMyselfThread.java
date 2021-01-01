package StudyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 创建多个线程执行代码
 */
public class CreateMyselfThread {

    private static final String TEXT = "今天又是美好的一天呀，我上午学习，" +
            "下午自由活动，就这么决定了哈哈哈哈哈，等会儿我在线上报个名看看，哼哼！！！";

    public static void main(String[] args) throws InterruptedException {
        // TODO 任何代码都可以通过Thread.currentThread()方法获取执行当前代码的线程
        System.out.println("程序开始，执行线程的名称为：" + Thread.currentThread().getName());

        // TODO interrupted方法是线程（Thread）里的方法
        List<Thread> threads = new ArrayList<>();   // 将线程保存在list中

        for(int i = 1; i <= 1; i++){
            //TODO Runnable接口里的run，是线程执行的方法，执行完毕线程就结束了
            // TODO 代码是在线程里被执行的，同样的代码可以被多个线程执行
            // 创建线程
            Thread thread = new Thread(new PrintStoryRunnable(TEXT,200 * i),"我的线程"+i);
//            Thread thread = new Thread(new NotHandleInterrupt(TimeUnit.SECONDS.toMillis(8)),"我的线程"+i);
//            // TODO 设置线程为守护线程
//            thread.setDaemon(true);
//            // TODO 可随时改变线程（是不是守护线程没有关系）的优先级，但是作用不能保证
//            thread.setPriority(Thread.MAX_PRIORITY);
//            // TODO 启动线程必须调用start方法，而不是run方法
            thread.start();
            thread.stop();
            threads.add(thread);  // 加入元素
        }
        Thread.sleep(TimeUnit.SECONDS.toMillis(5)); // 睡5秒，方便时间转换，例如：将5秒转换成毫秒
        System.out.println("开始 interrupt 线程");
        // TODO 如果线程不在sleep，或者在执行一些确实处理这个状态的方法，那么调用interrupt没有任何作用
        threads.forEach(Thread::interrupt); // 调用interrupt方法
        System.out.println("interrupt线程结束，继续睡5秒");
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println("线程结束，线程名字是" + Thread.currentThread().getName());
    }

    // 内部静态类
    static class PrintStoryRunnable implements Runnable {
        private String text;
        private long interval;

        // 构造方法
        public PrintStoryRunnable(String text,long interval){
            this.text = text;
            this.interval = interval;
        }
        @Override
        public void run() {
            try{
                System.out.println("执行这段代码的线程名字是：" + Thread.currentThread().getName());
                printSlowly(text,interval);  // 方法调用
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static void printSlowly(String text,long interval) throws InterruptedException {
        for(char c : text.toCharArray()){
            System.out.print(c);
            Thread.sleep(interval);
        }
        System.out.println();
    }

    /**
     * 执行 interrupt
     */
    private static class NotHandleInterrupt implements Runnable {
        private long during;

        // 构造方法
        public NotHandleInterrupt(long during) {
            this.during = during;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行开始");
            long start = System.currentTimeMillis(); // 获取系统当前时间
            long counter = 0;  // 计数器
            boolean isInterrupted = Thread.currentThread().isInterrupted(); // 是否执行interrupt,若被执行返回true
            System.out.println(Thread.currentThread().getName() + "的 isInterrupted = " + isInterrupted); // 输出状态
            System.out.println();
            while (true){
                counter++;
                // 判断之前的 isInterrupted 和 当前的 isInterrupted 状态是否一致
                if (isInterrupted != Thread.currentThread().isInterrupted()){
                    // 若不一致，重新赋值，并输出
                    isInterrupted = Thread.currentThread().isInterrupted();
                    System.out.println("发现线程" + Thread.currentThread().getName() + "的isInterrupted状态变为：" +
                            isInterrupted);
                    // TODO 代码自己可依决定要不要对 interrupt 进行处理，interrupt只是做一个标记
                    System.out.println("线程决定什么都不做");
                }
                // 判断消耗的时间，是否超过指定参数值
                if (System.currentTimeMillis() - start > during){
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "执行结束");
         }
    }
}
