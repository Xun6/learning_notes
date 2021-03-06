import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;
import extendsDemo.Phone;
import extendsDemo.ShellColorChangePhone;

public class InstanceOfTestAppMain {
    public static void main(String[] args){
        int merchandiseCount = 600;
        LittleSuperMarketV7 littleSuperMarketV7 = new LittleSuperMarketV7("大卖场",
                "世纪大道1号",500,merchandiseCount,100);

        // >>TODO instanceof 操作符，可以判断一个引用指向的一个对象是否是某一个类型或者其子类
        // >>TODO 是则返回true，否则返回 false
        for(int i=0; i < merchandiseCount; i++){
            Merchandise_V7 m = null; //littleSuperMarketV7.getMerchandiseOf(i);
            if(m instanceof Merchandise_V7){
                // TODO 先判断，在强制转换类型，比较安全
                Merchandise_V7 ph = (Merchandise_V7)m;
                System.out.println(ph.getName());
            } else {
                System.out.println("not an instanceof!");
            }
        }

        // >>TODO 若果引用是null，则肯定返回是false
    }
}
