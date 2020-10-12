package extendsDemo;

public class OverloadAndOverrideTestAppMain {
    public static void main(String[] args){
        LittleSuperMarketV7 superMarket = new LittleSuperMarketV7("大卖场","杭州萧山机场",
                600,300,200);
        Merchandise_V7 m = superMarket.getMerchandiseOf(100);

        // TODO 重载决定了要调用参数为 int 的方法，这个方法要在m 指向的对象上执行
        // TODO 分别用 true,1,3,6 做参数，运行结果是什么，为什么？？
        m.buy(6);
    }
}
