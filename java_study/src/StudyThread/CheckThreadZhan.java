package StudyThread;

public class CheckThreadZhan {
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        int a = 333;
        m2();
    }

    private static void m2() {
        int b = 777;
        m3();
    }

    private static void m3() {
        String d = null;
        m4();
    }

    private static void m4() {
        m5();
    }

    private static void m5() {
        System.out.println("线程完成");
    }
}
