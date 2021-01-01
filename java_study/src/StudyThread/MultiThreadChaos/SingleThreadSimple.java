package StudyThread.MultiThreadChaos;

/**
 * 单线程版例子
 */
public class SingleThreadSimple {
    public static void main(String[] args) {
        // TODO 对一个数据进行相同次数的加减，而且没有溢出
        DataHolder dataHolder = new DataHolder();

        // 递增
        ChangeData increase = new ChangeData(2, Integer.MAX_VALUE,dataHolder);
        increase.run();

        // 递减
        ChangeData decrease = new ChangeData(-2,Integer.MAX_VALUE,dataHolder);
        decrease.run();
    }
}
