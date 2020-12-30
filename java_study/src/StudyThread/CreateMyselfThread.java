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

//        // TODO interrupted方法是线程（Thread）里的方法
//        List<Thread> threads = new ArrayList<>();   // 将线程保存在list中

        for(int i = 1; i <= 1; i++){
            //TODO Runnable接口里的run，是线程执行的方法，执行完毕线程就结束了
            // TODO 代码是在线程里被执行的，同样的代码可以被多个线程执行
            // 创建线程
            Thread thread = new Thread(new PrintStoryRunnable(TEXT,200 * i),"我的线程"+i);
            // TODO 设置线程为守护线程
            thread.setDaemon(true);
            // TODO 可随时改变线程（是不是守护线程没有关系）的优先级，但是作用不能保证
            thread.setPriority(Thread.MAX_PRIORITY);
            // TODO 启动线程必须调用start方法，而不是run方法
            thread.start();
        }
//        Thread.sleep(TimeUnit.SECONDS.toMillis(5)); // 方便时间转换，例如：将5秒转换成毫秒
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
}
