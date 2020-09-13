package LearnMain;

public class LearnMainDemo {
    public static void main(String[] args){
        System.out.println(args.length);

        //获取当前时间，单位毫秒
        long star = System.currentTimeMillis();
        System.out.println(star);
        //获取当前时间，单位是那纳秒
        System.out.println(System.nanoTime());
    }
}
