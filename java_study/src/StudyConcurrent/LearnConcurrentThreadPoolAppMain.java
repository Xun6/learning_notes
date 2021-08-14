package StudyConcurrent;

import java.util.concurrent.*;

/**
 * 学习使用 concurrent 包中的线程池
 */
public class LearnConcurrentThreadPoolAppMain {
    public static void main(String[] args) {
        // TODO 查看 ThreadPoolExecutor 完整形态的构造方法，了解构建一个线程池考虑的各种参数
        ExecutorService executorService = Executors.newFixedThreadPool(1); // 创建固定线程池

        // 方法一，无参无返回 提交一个 runnable
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                printExecutionThreadStatus("run方法");
            }
        });
        System.out.println("已提交run task");

        //方法二，提交一个带返回值（string类型）
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                printExecutionThreadStatus("call方法");
                System.out.println("执行call任务ing。。。");
                Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                System.out.println("执行call任务结束");
                return "这是call返回的结果";
            }
        });
        System.out.println("已经提交call task");

        System.out.println("任务提交完毕");
        // TODO 关闭线程池，shutdown方法会等待所有已经提交的任务完成，然后释放所有资源
        // TODO 正常应该在应用程序需要结束的时候，将工作线程池关闭，这里为了演示，提交完任务就关闭了
        System.out.println("关闭线程池");
        // 等待所有任务结束，关闭线程池，释所有放线程资源
        executorService.shutdown(); // 先调用shutdown方法，已关闭之后不再接受新提交的task，但是已经提交的task会执行

        try{
            System.out.println("开始获取call task的执行结果");
            String res = future.get(); //获取call计算后的返回结果
            System.out.println("获取到了任务执行的结果，为：" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void printExecutionThreadStatus(String phase) {
        System.out.println(Thread.currentThread().getName() + ":这是在线程池里执行的代码：" + phase);
    }
}
