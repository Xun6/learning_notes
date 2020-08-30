package com.xiaoyu.xiaoChaoShi;
/**
 * 计算毛利润最高的商品
 * */
import com.xiaoyu.xiaoChaoShi.supermarket.LittleSuperMarketV4;
import com.xiaoyu.xiaoChaoShi.supermarket.MerchandiseV4;

public class RunSuperMarketAppMainV4 {
    public static void main(String[] args){
        LittleSuperMarketV4 littleSuperMarketV4 = new LittleSuperMarketV4();
        littleSuperMarketV4.merchandisesV4 = new MerchandiseV4[200]; //初始化商品元素
        littleSuperMarketV4.merchandiseSold = new int[littleSuperMarketV4.merchandisesV4.length];

        MerchandiseV4[] all = littleSuperMarketV4.merchandisesV4; //取出数组引用

        //创建 gift 实例
        MerchandiseV4 giftNoodle = new MerchandiseV4();
        giftNoodle.name = "赠品-面条";
        giftNoodle.count = 2000;
        giftNoodle.purchasePrice = 5;
        giftNoodle.soldPrice = 0.5;
        giftNoodle.id = "GIFT001";

        MerchandiseV4 giftBowl = new MerchandiseV4();
        giftBowl.name = "赠品-碗";
        giftBowl.count = 2000;
        giftBowl.purchasePrice = 8;
        giftBowl.soldPrice = 0.8;
        giftBowl.id = "GIFT002";

        //给商品元素赋值
        for(int i =0; i <all.length; i++){
            MerchandiseV4 m = new MerchandiseV4();
            m.name = "商品编号" +i;
            m.id = "商品ID" +i;
            m.count = 200;
            m.purchasePrice = Math.random() * 100;
            m.soldPrice = (1+Math.random()) * 100;
            m.gift = giftNoodle;  //给所有商品赠送一个 giftNoodle
            all[i] = m;
            m.describe();  //调用方法
        }


        //--------------------- 参数和返回值是怎样传递的 ----------------------------
        MerchandiseV4 m1 = all[0];

        // >>TODO 方法里的代码并不能改变实参的值
        // >>TODO 方法里使用的参数相当于一个局部变量，使用方法前，会用实参给局部变量赋值
        MerchandiseV4 paramRef = littleSuperMarketV4.merchandisesV4[2];
        int paramPrime = 7;

        System.out.println("使用前：");
        System.out.println(paramPrime);
        System.out.println(paramRef);
        //调用方法
        m1.willOutsideValueChangeIfParameterValueChangeHerePrime(paramPrime);

        m1.willOutsideValueChangeIfParameterValueChangeHereRef(paramRef);

        System.out.println("使用后：");
        System.out.println(paramPrime);
        System.out.println(paramRef);


        //------------------ 返回值 ---------------------
        // >>TODO 可以把有返回值的方法，当成一个成员变量，当成一个类型为返回值类型的成员变量
        // >>
        double soldPrice = m1.getSoldPrice();   //把调用方法的返回值赋值给 成员变量
        System.out.println(soldPrice);
        m1.describe();

        System.out.println("执行getGiftAndHowCanOutSideChangeIt和getSoldPrice方法之前：");
        m1.describe();

        MerchandiseV4 giftOfM1 = m1.getGiftAndHowCanOutSideChangeIt();  //调用方法的返回值给引用变量
        giftOfM1 = giftBowl;   //重新赋值
        double m1soldPrice = m1.getSoldPrice();
        m1soldPrice = 9999999;  //重新赋值

        System.out.println("执行getGiftAndHowCanOutSideChangeIt和getSoldPrice方法之后，能改变调用方法的返回值吗？？：");
        m1.describe();
    }
}
