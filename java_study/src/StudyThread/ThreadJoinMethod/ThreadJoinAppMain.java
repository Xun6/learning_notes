package StudyThread.ThreadJoinMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * join方法的运用示例
 */
public class ThreadJoinAppMain {
    private static final List<String> CONTENTS = new ArrayList<>();
    private static long WORKING_DURATION = 0;  // 工作持续时间

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis(); // 记录主线程开始时间
        List<Thread> threads = new ArrayList<>(); // 创建存放线程的list集合

        // 创建 10 个工作线程，模拟抓取网页内容
        for (int i = 0; i<10; i++){
            Thread thread = new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + ":开始抓取网页");
                long workStartTime = System.currentTimeMillis();  // 工作开始时间
                String content = getContentFromWeb(); // 抓取内容
                long threadWorkDurtion = System.currentTimeMillis() - workStartTime; // 工作持续的时间
                System.out.println(Thread.currentThread().getName() + ":抓取结束");
                // 抓取的内容存放在 List 中
                // TODO 为什么要写在同步控制中 ？？？   确保每个线程先后进入，统计模拟的工作时间
                synchronized (CONTENTS){
                    CONTENTS.add(content);
                    WORKING_DURATION += threadWorkDurtion; // 统计线程工作总时间
                }
            },"工作线程" + i);
            thread.start();
            threads.add(thread); // 把线程添加到 List 中
        }

        // TODO sleep一下，让线程都启动起来
        Thread.sleep(1);

        System.out.println("---------主线程开始 join-----------");
        for (Thread thread : threads){
            try{
                String name = thread.getName(); // 获取线程名称
                System.out.println("-----主线程join开始：" + name + "------");
                thread.join();
                System.out.println("-----主线程join：" + name + "结束-----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------------------主线程join结束，获取的内容为：------------------");
        CONTENTS.forEach(s -> {
            System.out.print(s.length() + ": ");
            System.out.println(s);
        });

        // 主线程总工作时间
        long mainWorkDurtion = System.currentTimeMillis() - startTime;

        // TODO
        System.out.println("工作线程累计工作时间：" + WORKING_DURATION);
        System.out.println("主线程总工作时间：" + mainWorkDurtion);
    }

    // 模拟网页抓取逻辑
    private static String getContentFromWeb() {
        StringBuilder ret = new StringBuilder();
        int len = (int)(Math.random() * 4000 + 1024) ;
        for (int i =0; i < len; i++){
            char ch = (char)(Math.random() * 26 + 'a');
            ret.append(ch);
            try{
                Thread.sleep(1);  // 睡一毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ret.toString();
    }
}
