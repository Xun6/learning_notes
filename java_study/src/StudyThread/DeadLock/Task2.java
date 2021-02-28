package StudyThread.DeadLock;

import java.util.concurrent.TimeUnit;

/**
 * 模拟任务二
 */
public class Task2 implements Runnable{
    private AppResources appResources;

    public Task2(AppResources appResources){
        this.appResources = appResources;
    }


    @Override
    public void run() {
        // TODO 申请资源顺序不同
        differentSeq();
    }

    private void differentSeq() {
        // TODO 先申请 ResourcePrint资源
        synchronized (appResources.getResourcePrint()){
            System.out.println("Tesk2 得到了ResourcePrint资源！");
            System.out.println("Tesk2 开始工作！");
            // 模拟工作 3 秒
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 模拟不释放锁 继续申请 ResourceInput资源
            System.out.println("尝试继续获取 ResourceInput资源！");
            synchronized (appResources.getReourceInput()){
                System.out.println("Tesk2 得到了ReourceInput资源！");
                System.out.println("Tesk2 继续工作... ...");
                try{
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
