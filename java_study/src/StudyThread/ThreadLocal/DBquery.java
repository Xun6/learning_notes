package StudyThread.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * 模拟查询处理
 */
public class DBquery {
    public void query() {
        PerformanceTracker.startPhase(); // 调用，模拟开始阶段
        try{
            Thread.sleep((int)(Math.random() * TimeUnit.SECONDS.toMillis(5)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PerformanceTracker.endPhace("DBquery"); // 调用，模拟结束阶段
    }
}
