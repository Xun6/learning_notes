package StudyThread.ProducerAndConsumer;

import java.util.Queue;

/**
 * 这是一个生产者
 *
 */
public class Producer<T> {
    private Queue<T> tasks; // 队列引用成员变量
    private int maxTaskCount; //定义最大任务数

    // 构造方法
    public Producer(Queue<T> tasks,int maxTaskCount){
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    // 把任务 task 放到队列里去
    public void produce(T task) throws InterruptedException {
        // 锁在队列上
        synchronized (tasks){
            // 检查，当任务数超过队列最大范围，就进入等待
            while(tasks.size() >= maxTaskCount){
                System.out.println("生产者线程进入等待：" + Thread.currentThread().getName());
                // 进入等待并释放 monitor
                tasks.wait();
            }
            // 添加元素
            tasks.add(task);
            tasks.notifyAll(); // 考虑到消费者等待接受任务的时候情况
        }
    }
}
