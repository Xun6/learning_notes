package StudyVolatile;

/**
 * Volatile 关键字学习
 */
public class VolatileAppMain {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        // TODO 创建两个线程，一个操作数据，一个检查数据
        Thread operator = new Thread(() ->{
            while(true){
                dataHolder.operateData();
            }
        });
        operator.start();

        Thread checkor = new Thread(() ->{
            while(true){
                dataHolder.check();
            }
        });
        checkor.start();
    }
}
