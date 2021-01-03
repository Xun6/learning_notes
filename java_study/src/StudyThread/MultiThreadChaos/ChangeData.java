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
//            dataHolder.change(delta); // 递增delta
            // TODO 调用 synchronized修饰的静态方法
//            DataHolder.changeStatic(delta);
            dataHolder.changeSyncBlock(delta); // 代码块控制线程同步
        }
        dataHolder.print(); // 输出number
//        DataHolder.printStatic(); // 调用静态方法 ，输出number
    }
}
