package StudyConcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Concurrent包的学习
 * Atomic类族，AtomicLong的线程安全性（先与旧值对比，若相同，则执行加一；若不同，取出内存地址中的值，再加一；确保多线程时，每次取出的值都是最新值）
 */
public class LearnConcurrentAppMain {
    private AtomicLong atomicLong = new AtomicLong(0); //初始化并存储 atomicLong
    private volatile long longVar =0; // 初始化并存储 longVar

    public static void main(String[] args) throws InterruptedException {
        // AtomicLong线程安全性演示示例
        LearnConcurrentAppMain atomicNumber = new LearnConcurrentAppMain();
        int loop = Integer.MAX_VALUE / 10; //初始化循环执行次数

        //TODO 并发使用线程给AtomicLong 对象加一
        int parallel = 10;
        List<Thread> atomicThreads = new ArrayList<>();
        for (int p=0; p < parallel; p++) {
            int loopCount = loop / parallel; //均分10个线程的循环执行此时
            if(p == parallel -1){
                loopCount = loop - (loop / parallel) * (parallel - 1); // 因线程执行不均，计算最后一个线程需要循环执行的次数
            }
            int finalLoopCount = loopCount;
            Thread atomic = new Thread(()-> {
               long start = System.currentTimeMillis();
               for(int i=0;i <finalLoopCount; i++){
                   long res = atomicNumber.atomicLong.incrementAndGet();  //循环加一
                   if(i == 1){
                       System.out.println(res);
                   }
               }
               System.out.println("Atomic takes "+(System.currentTimeMillis() - start));//打印每个线程的执行时间
            });
            atomic.start();
            atomicThreads.add(atomic); // 加入Thread链表
        }


        //TODO 单线程给long的变量加一
        Thread primary = new Thread(() ->{
           long start = System.currentTimeMillis();
           for(int i=0; i< loop; i++){
               atomicNumber.longVar++;
           }
           System.out.println("Primary var takes "+ (System.currentTimeMillis() - start));
        });
        primary.start();

        //确保每个线程执行结束
        for(Thread atomicT : atomicThreads){
            atomicT.join();
        }
        primary.join();

        //TODO 多线程和单线程的结果是一样的
        System.out.println(atomicNumber.toString());
    }


    @Override
    public String toString() {
        return "AtomicNumer{ "+"atomicLong="+ atomicLong+
                ", longVar="+ longVar+
                " }";
    }
}
