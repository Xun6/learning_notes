package ExceptionStudy;

public class TryCatchFinallyAppMain {
    private static int VAL = 0;

    public static void main(String[] args){
        System.out.println(withFinally());
        System.out.println(VAL);

    }


    private static int withFinally(){
        int len = 0;
        try{
            String s = null;
            return s.length(); // 异常
        }catch (Exception ex){
            len = -1;
            System.out.println("执行catch里面的return语句");
            return len;
        } finally {
            // TODO 无论是因为return结束还是异常结束，finally语句都会执行
            System.out.println("执行finally语句");
            // TODO finally里最好不要有return语句
//            return 2;
            // TODO finally里给给return的变量赋值，没有用
//            len = -2;
            VAL = 999;
            System.out.println("finally语句执行完毕！");
        }
    }
}
