package StudyThread.ThreadLocal;

/**
 * 模拟输入处理
 */
public class InputHandle {

    public String getInput() {
        PerformanceTracker.reset(); //调用,模拟重置
        return produceString();
    }

    private static String produceString() {
        PerformanceTracker.startPhase();  // 调用，模拟开始阶段
        StringBuilder stringBuilder = new StringBuilder();
        // 模拟处理逻辑
        for(int i=0; i <128; i++){
            int rand = (int)(Math.random() * 1000) % 26;
            char ch = (char)(rand + 'a');
            stringBuilder.append(ch);
        }
        PerformanceTracker.endPhace("inputGen"); // 调用，模拟结束阶段
        return stringBuilder.toString();
    }
}
