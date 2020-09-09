package com.xiaoyu.staticDemo;

/**
 * static代码块 和 static变量初始化
 */
public class DiscountMgr {
    public static void main(String[] args){
        System.out.println("最终 main方法中使用的SVIP_DISCOUNT是："+ SVIP_DISCOUNT);

    }

    public static double BASE_DISCOUNT;
    public static double VIP_DISCOUNT;
    public static double SVIP_DISCOUNT;
    // >> TODO 使用某个静态变量的代码块必须在静态变量后面
    static{
        BASE_DISCOUNT = 0.99;
        VIP_DISCOUNT = 0.95;
        SVIP_DISCOUNT = 0.80;

        System.out.println("静态代码块 1中的SVIP_DISCOUNT:"+SVIP_DISCOUNT);
    }

    static {
        SVIP_DISCOUNT = 0.1;
        System.out.println("静态代码块 2中的SVIP_DISCOUNT:"+SVIP_DISCOUNT);
    }
}
