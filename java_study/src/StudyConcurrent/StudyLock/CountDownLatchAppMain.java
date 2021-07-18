package StudyConcurrent.StudyLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 学习 CountDownLatch 方法，对标 join 方法，确保线程执行完毕
 */
public class CountDownLatchAppMain {
    private static final List<String> CONTENTS = new ArrayList<>(); // 保存内容
    private static long WORKING_DURATION = 0; //保存时间

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10; //定义线程数量
        CountDownLatch countDownLatch = new CountDownLatch(threadCount); // 线程计数
        long mainStart = System.currentTimeMillis(); // 记录开始时间
        // 创建 10 个线程
        for (int i =0; i < threadCount; i++) {
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName() + ": 开始抓取网页内容");
                long start = System.currentTimeMillis();
                String content = getContentFromWeb(); // 执行抓取
                long threadWorkingDuration = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + ": 抓取网页内容结束");
                // 同步控制
                synchronized (CONTENTS){
                    CONTENTS.add(content);
                    WORKING_DURATION += threadWorkingDuration;
                }
                // TODO 只需要 countDown 即可，不需要结束，线程可以继续作别的事情
                countDownLatch.countDown(); // 计数减一
                try{
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束");
            },"线程-" + i);
            thread.start();
        }

        // TODO  无需等待，直接 await ， 比 join方法好的地方之一，join必须确保线程已经start
        countDownLatch.await();
        CONTENTS.forEach(s->{
            System.out.println(s.length() + ": ");
            System.out.println(s);
        });

        long mainworkDuration = System.currentTimeMillis() - mainStart; // 记录主线程工作时长

        System.out.println("工作线程累计时长：" + WORKING_DURATION);
        System.out.println("主线程工作时间：" + mainworkDuration);
        System.out.println("主线程结束");
    }

    // 模拟产生数据
    private static String getContentFromWeb() {
        StringBuilder stringBuilder = new StringBuilder();
        int len = (int)(Math.random() * 1000000) % 4096 + 1024;
        for (int i=0; i < len; i++){
            int rand = (int)(Math.random() * 1000) % 26;
            char ch = (char)(rand + 'a');
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
