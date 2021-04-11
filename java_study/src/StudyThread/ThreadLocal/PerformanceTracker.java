package StudyThread.ThreadLocal;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTracker {
    // 静态内部类
    private static class Phase{
        private String name;
        private long duration;
        /**
         * 构造方法
         * @param name 当前阶段的名称
         * @param duration  执行了多长时间
         */
        public Phase(String name,long duration){
            this.name = name;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Phase{" +
                    "name='" + name + '\'' +
                    ", duration=" + duration +
                    "}\n";
        }
    }

    // TODO ThreadLocal 一般都是 static的
    // TODO 这样使用ThreadLocal，这些程序不用在应用程序之间传递，而且还可以为每个线程保留一份自己的数据
    // 创建两个ThreadLocal
    private static final ThreadLocal<List<Phase>> PHASES = new ThreadLocal<>();
    private static final ThreadLocal<Long> PHASE_START_TIME = new ThreadLocal<>();

    public static void finish() {
        List<Phase> phases = PHASES.get(); // 获取所有的Phase
        PHASES.set(null); // 清空
        PHASE_START_TIME.set(null); // 清空

        StringBuilder out = new StringBuilder("-----------Thread Execution Phase Durations-------------\n");
        phases.forEach(out::append);
        out.append("--------------------------------\n");
        System.out.println(out.toString());
    }

    // 把两个ThreadLocal设置为初始值
    public static void reset() {
        PHASES.set(new ArrayList<>()); //
        PHASE_START_TIME.set(-1L);
    }

    // 记录当前 phase(阶段) 的开始时间
    public static void startPhase() {
        PHASE_START_TIME.set(System.currentTimeMillis());
    }

    // 统计phase(阶段)处理时间
    public static void endPhace(String phaseName) {
        long start = PHASE_START_TIME.get(); // 取出开始时间
        PHASES.get().add(new Phase(phaseName,System.currentTimeMillis() - start));
    }
}
