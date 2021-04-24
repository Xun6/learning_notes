package StudyVolatile;

public class DataHolder {
    int a,b,c,d,f,g;
//    long e;
    // TODO 使用 volatile 修饰变量，会影响之前出现的 指令重排
    volatile long e;
    public void operateData(){
    // TODO 若按顺序执行，g的值肯定会小于或等于 e 的值，当实际执行的时候可能会为了优化重排
        a += 1;
        b += 1;
        c += 1;
        d += 1;

        e += 1;

        f += 1;
        g += 1;
    }

    int counter;
    public void check(){
        // TODO 看似不可能，实际在指令重排情况下会出现
        if(g > e){
            System.out.println("got it " + counter++);
        }
    }
}
