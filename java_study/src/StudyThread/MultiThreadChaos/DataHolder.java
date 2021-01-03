package StudyThread.MultiThreadChaos;

/**
 * 数据提供者
 */
public class DataHolder {
    private  static Object object = new Object();
    private long number = 0;
    private static long numberStatic = 0;  // 静态成员变量

    // TODO 使用 synchronized 解决同一对象，多线程执行混乱问题
    public synchronized void change(long num){
        number += num;
    }

    // TODO 使用 synchronized 解决问题
    // 静态方法
    public synchronized static void changeStatic(long numb){
        numberStatic += numb;
    }


    public void changeSyncBlock(long numb){
        // TODO 使用synchronized 代码块，控制同步线程问题
        synchronized (object){
            number += numb;
        }
    }

    public void print(){
        System.out.println("number = " + number);
    }

    // 静态方法
    public static void printStatic(){
        System.out.println("number = " + numberStatic);
    }
}
