package StudyVolatile;

/**
 * 对比 volatile 修饰的变量从内存读取的速度
 */
public class AccessMemoryVolatile {
    public volatile long counterV = 0;
    public long counter = 0;

    public static void main(String[] args) {
        int loopcount = Integer.MAX_VALUE / 30;
        System.out.println(loopcount);
        // TODO volatile 每次读取都要直达内存，不能使用缓存，所以耗费的时间略多
        AccessMemoryVolatile accessMemoryVolatile = new AccessMemoryVolatile();
        Thread volatileAdder = new Thread(() ->{
            long start = System.currentTimeMillis();
            for (int i = 0; i < loopcount; i++){
                accessMemoryVolatile.counterV++;  // volatile 修饰的变量
            }
            System.out.println("volatile adder takes " + (System.currentTimeMillis() - start));
        });
        volatileAdder.start();


        Thread simpleAdder = new Thread(() ->{
            long start = System.currentTimeMillis();
            for (int i =0 ; i < loopcount; i++){
                accessMemoryVolatile.counter++; // 非 volatile 修饰的变量
            }
            System.out.println("simple adder takes " + (System.currentTimeMillis() - start));
        });
        simpleAdder.start();
    }
}
