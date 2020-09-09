package com.xiaoyu.xiaoChaoShi;

import com.xiaoyu.xiaoChaoShi.supermarket.LittleSuperMarket;
import com.xiaoyu.xiaoChaoShi.supermarket.Merchandise_V6;

/**
 * 成熟的类的对象 要自己做事情
 */
public class RunSuperMarketAppMain_V6 {
    public static void main(String[] args){

        LittleSuperMarket littleSuperMarket = new LittleSuperMarket("小鱼超市","浙江省宁波市北仑区小港接到",
                200,300);
        System.out.println(littleSuperMarket);
//        Merchandise_V6 merchandise_v6 = new Merchandise_V6();
        Merchandise_V6 merchandise_v6 = Merchandise_V6.createMerchandise("书桌","DESK9527",40,999.00,500);
        // >> TODO 调用方法，完成对成员变量的操作
//        merchandise_v6.init("书桌","DESK9527",40,999.00,500);
        merchandise_v6.descript();

        double res = merchandise_v6.buy();
        System.out.println(res);

        double csot = merchandise_v6.buy(3);
        System.out.println(csot);
//
        double Cost = merchandise_v6.buy(3,true);
        System.out.println(Cost);

        //输出静态变量的值
        System.out.println(merchandise_v6.DISCOUNT_FOR_VIP);
    }
}
