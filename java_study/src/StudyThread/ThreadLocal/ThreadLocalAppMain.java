package StudyThread.ThreadLocal;

/**
 * 主程序入口, ThreadLocal运用示例
 */
public class ThreadLocalAppMain {
    // TODO Threadlocal一般用在跨类，跨方法传递一些值

    public static void main(String[] args) {
        // 创建三个线程
        for(int i =0; i< 3; i++){
            Thread workThreads = new Thread(() ->{
                System.out.println("----开始处理----");
                // TODO 如下三个处理步骤，都是用一个线程执行
                InputHandle inputHandle = new InputHandle();
                String content = inputHandle.getInput();

                DBquery query = new DBquery();
                query.query();

                ContentProcess contentProcess = new ContentProcess();
                contentProcess.process(content);

                PerformanceTracker.finish();  //完成统计
                System.out.println("--处理结束--");
            },"Worker"+i);
            workThreads.start();
        }

    }
}
