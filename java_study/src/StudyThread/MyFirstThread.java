package StudyThread;


public class MyFirstThread {
    public static void main(String[] args) throws InterruptedException {
        processThread("今天又是美好的一天呀，我上午学习，下午自由活动，就这么决定了哈哈哈哈哈，等会儿我在线上报个名看看，哼哼！！！",300);

    }


    private static void processThread(String text,long interval) throws InterruptedException {
        for(char ch : text.toCharArray() ){
            System.out.print(ch);
            Thread.sleep(interval);
        }
        System.out.println();
    }
}
