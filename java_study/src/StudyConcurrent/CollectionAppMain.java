package StudyConcurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * concurrent包中的数据结构，相关方法的使用
 */
public class CollectionAppMain {
    public static void main(String[] args) {
        // TODO 元素不能为null
        // TODO 默认大小为 Integer.MAX_VALUE
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(128);

        //获取队列最前面的，但是不出列
        linkedBlockingQueue.peek();

        // TODO 将元素放入队列，返回是否放入成功，一般在限制队列的大小的情况下才会返回失败，毕竟达到了 Integer.MAX_VALUE程序可能就因为没有内存挂了
        // TODO 这个方法也可传入超时时间
        boolean added = linkedBlockingQueue.offer("");

        // TODO 队列里有就拿出来，没有就返回空，还有超时重载版本
        linkedBlockingQueue.poll();

        try{
            // TODO 将元素加入队列，如果队列满了，就等着
            linkedBlockingQueue.put("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO 一定要拿到一个，否则就无限等待
        try{
            linkedBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO put 和 take 可以很方便的实现生产者消费者
    }
}
