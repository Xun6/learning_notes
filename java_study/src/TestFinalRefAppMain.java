import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;
import extendsDemo.Phone;

//TODO final修饰引用变量：
   //TODO 引用本身的内容不可改
   //TODO 不能指向其他引用
   //TODO 引用指向的地址内容，非final修饰的可以更改

// >> TODO final 修饰类，不能有子类
   //TODO final修饰方法，不能被覆盖
   //TODO final修饰变量，要赋一个值，且不能改变

public class TestFinalRefAppMain {
    public static void main(String[] args){
        LittleSuperMarketV7 superMarket = new LittleSuperMarketV7("大卖场","杭州萧山机场",
                600,300,200);
        Phone m = (Phone) superMarket.getMerchandiseOf(10);

        Merchandise_V7 gift = m.getGift();
        gift.describe();
        gift.setName("改个名字哈？");
        gift.setSoldPrice(88888);
        gift.describe();
    }
}
