package StudyThread.ProducerAndConsumer;

import java.util.Queue;

/**
 * 这是一个消费者
 *
 */
// 对象类型需满足泛型类型 T
public class Consumer<T> {
    private Queue<T> tasks;  // 成员变量，对象的引用

    // 构造函数
    public Consumer(Queue<T> tasks){
        this.tasks = tasks;
    }


    public T consumer() throws InterruptedException {
        synchronized (tasks){
            // 判断tasks队列若为空，进入等待
            while(tasks.size() == 0){
                System.out.println("消费者线程进入等待：" + Thread.currentThread().getName());
                tasks.wait();
            }
            // 若不为空，拿出队列中的头部元素
            T ret = tasks.poll();
            tasks.notifyAll(); // 唤醒生产者的等待
            return ret;
        }
    }
}
