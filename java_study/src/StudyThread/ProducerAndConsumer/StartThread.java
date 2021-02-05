package StudyThread.ProducerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * 这是主运行程序
 *
 */
public class StartThread {
    public static void main(String[] args) {
        // 创建队列
        Queue<String> queue = new LinkedList<>();

        // 创建生产者和消费者
        Producer<String> producer = new Producer<>(queue,1024);
        Consumer<String> consumer = new Consumer<>(queue);
        // 创建100个工作线程
        for(int i = 0;i < 100; i++){
            Thread consumerThread = new Thread(() ->{
                while(true){
                    try {
                        String url = consumer.consumer(); // 调用消费者方法，取出队列中的任务
                        processUrl(url); // 模拟执行工作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"消费者-" + i);
            consumerThread.start(); // 开始执行线程
        }

        // 创建3个生产线程
        for (int i =0; i < 3; i++){
            Thread producerThread = new Thread(() -> {
                while(true){
                    try{
                        String urls = produceURL(); // 模拟生产任务
                        producer.produce(urls); // 把任务添加到队列中
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"生产者-" + i);
            producerThread.start(); // 开始执行线程
        }


    }

    // 模拟生产者生产
    private static String produceURL() {
        StringBuilder ret = new StringBuilder();
        ret.append("www.");
        //生成随机的六个字符
        for (int i = 0; i < 6; i++){
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    // 模拟消费者处理任务
    private static void processUrl(String url) throws InterruptedException {
        System.out.println("开始处理：" + url);
        // 睡一毫秒
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("处理结束：" + url);
    }
}
