package StudyTimedTask;

import java.util.TimerTask;

// TODO 必须继承 TimeTask 才能被 Time schedule（定时任务）
public class FindABCTask extends TimerTask {
    @Override
    public void run() {
        try{
            String content = getWebContent();
            // 判断
            if (content.contains("ABC")){
                System.out.print("Find 'ABC' in " + content );
            } else {
                System.out.println("Not find 'ABC'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO 如果抛出异常，Timer是不会帮助处理的，整个Timer就挂了
//        throw new RuntimeException("not handled exception");
    }

    // 模拟处理逻辑
    private String getWebContent() {
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < 4098; i++){
            int rand = (int)(Math.random() * 1000) % 26;
            char ch = (char)(rand + 'A');
            ret.append(ch);
        }
        return ret.toString();
    }
}
