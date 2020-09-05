package com.xiaoyu.xiaoChaoShi;
/**
 * 计算毛利润最高的商品
 * */
import com.xiaoyu.xiaoChaoShi.supermarket.LittleSuperMarketV4;
import com.xiaoyu.xiaoChaoShi.supermarket.MerchandiseV4;

public class RunSuperMarketAppMainV5 {
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


        //------------- 转化商品赠送的商品 -----------------
        int index = 0;

        MerchandiseV4 merchandiseV4 = all[index]; //第 index 个商品
        MerchandiseV4 m2paramRef = littleSuperMarketV4.merchandisesV4[2]; //第三个商品
        merchandiseV4.gift = giftBowl; //给引用变量赋值

        System.out.println("gift转换方法执行之前：");
        merchandiseV4.describe();
        m2paramRef.describe();

        //执行方法
        merchandiseV4.changeToTheSameGift(m2paramRef);

        System.out.println("gift转换方法执行之后：");
        m2paramRef.describe();


        //--------  修改赠送商品的价格 -----------
        // >> TODO 可以通过返回值，操作同一个对象
        //获取 merchandiseV4 的赠品，并修改这个赠品对象的采购价格
        MerchandiseV4 m4;  //声明一个引用变量
        System.out.println("修改前：");
        merchandiseV4.describe();

        //执行方法
        m4 = merchandiseV4.getGiftAndHowCanOutSideChangeIt();   //指向同一个gift对象
        m4.purchasePrice = m4.purchasePrice * 10; //修改价格

        System.out.println("修改后：");
        merchandiseV4.describe();

    }
}
