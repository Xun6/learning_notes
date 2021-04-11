package StudyThread.ThreadLocal;

/**
 * 模拟内容处理
 */
public class ContentProcess {
    public void process(String content) {
        PerformanceTracker.startPhase(); // 调用，模拟开始阶段
        long ms = content.chars().reduce(Integer::sum).orElse(0);
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PerformanceTracker.endPhace("contentProcess");// 调用，模拟结束阶段
    }
}
