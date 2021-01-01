package StudyThread.MultiThreadChaos;

/**
 * 改变数据逻辑
 */
public class ChangeData implements Runnable{
    private long delta;
    private long loopCount; // 循环次数
    private DataHolder dataHolder; // 引用变量

    // 构造方法
    public ChangeData(long delta,long loopCount,DataHolder dataHolder){
        this.delta = delta;
        this.loopCount = loopCount;
        this.dataHolder = dataHolder;
    }

    @Override
    public void run() {
        for(int i = 0; i < loopCount; i++){
            dataHolder.change(delta); // 递增delta
        }
        dataHolder.print(); // 输出number
    }
}
