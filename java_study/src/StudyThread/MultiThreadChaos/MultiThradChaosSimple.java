package StudyThread.MultiThreadChaos;

/**
 * 多线程混乱例子
 */
public class MultiThradChaosSimple {
    public static void main(String[] args) {
        // TODO 同一个运算，安排在多个线程里执行，结果就不太一样了
        DataHolder dataHolder = new DataHolder();
        Thread increaseThread = new Thread(new ChangeData(2,Integer.MAX_VALUE,dataHolder));
        Thread decreaseThread = new Thread(new ChangeData(-2,Integer.MAX_VALUE,dataHolder));
        System.out.println("------------执行开始-------------");
        increaseThread.start();
        decreaseThread.start();
    }
}
