package StudyTimedTask;

import java.util.Timer;

public class LearnTimerAppMain {
    public static void main(String[] args) {
        // 此对象用来调度定时任务
        Timer timer = new Timer();
        // TODO 使用固定的频率scheldule任务
        timer.scheduleAtFixedRate(new FindABCTask(),0,200);
    }

}
