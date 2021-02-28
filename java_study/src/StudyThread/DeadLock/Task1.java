package StudyThread.DeadLock;

import java.util.concurrent.TimeUnit;

/**
 * 模拟任务一
 */
public class Task1 implements Runnable{
    private AppResources appResources;
    // 构造方法
    public Task1(AppResources appResources){
        this.appResources = appResources;
    }

    @Override
    public void run() {
        // TODO 先申请 ReourceInput 资源
        synchronized (appResources.getReourceInput()){
            System.out.println("Tesk1 得到了ResourceInput资源！");
            System.out.println("Tesk1 开始工作！");
            // 模拟工作 2 秒钟
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // TODO 模拟不释放锁的情况下，继续申请资源
            System.out.println("尝试继续获取 ResourcePrint资源！");
            synchronized (appResources.getResourcePrint()){
                System.out.println("Tesk1 得到了ResourcePrint资源！");
                System.out.println("Tesk1 继续工作... ...");
                try{
                    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
