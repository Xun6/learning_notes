import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;

public class LittleSuperMarketAppMain {
    public static void main(String[] args){
        LittleSuperMarketV7 littleSuperMarketV7 = new LittleSuperMarketV7("大卖场","杭州萧山区蜀山街道",
                600,300,200);

        Merchandise_V7[] all = littleSuperMarketV7.getMerchandisesV7();
        // TODO for循环的另一种写法，
        // TODO 只循环遍历，不赋值，不跳跃访问，不需要知道当前元素是第几个
        double maxPurchesPrice = -1;
        for(Merchandise_V7 m : all){
            if(m.getPurchasePrice() > maxPurchesPrice){
                maxPurchesPrice = m.getPurchasePrice();
            }
        }
        System.out.println(maxPurchesPrice);
        System.out.println(littleSuperMarketV7.getBiggerPurchesPrice());
    }
}
