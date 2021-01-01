package StudyThread.MultiThreadChaos;

/**
 * 数据提供者
 */
public class DataHolder {
    private long number = 0;

    public void change(long num){
        number += num;
    }

    public void print(){
        System.out.println("number = " + number);
    }
}
