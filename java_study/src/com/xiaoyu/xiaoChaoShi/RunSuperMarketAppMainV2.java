package com.xiaoyu.xiaoChaoShi;
/**
 * 计算毛利润最高的商品
 * */
import com.xiaoyu.xiaoChaoShi.supermarket.LittleSuperMarketV2;
import com.xiaoyu.xiaoChaoShi.supermarket.MerchandiseV2;

public class RunSuperMarketAppMainV2 {
    public static void main(String[] args){
        LittleSuperMarketV2 littleSuperMarketV2 = new LittleSuperMarketV2();
        littleSuperMarketV2.merchandises = new MerchandiseV2[200]; //初始化商品元素
        littleSuperMarketV2.merchandiseSold = new int[littleSuperMarketV2.merchandises.length];

        MerchandiseV2[] all = littleSuperMarketV2.merchandises; //取出数组引用
        //给商品元素赋值
        for(int i =0; i <all.length; i++){
            MerchandiseV2 m = new MerchandiseV2();
            m.name = "商品编号" +i;
            m.id = "商品ID" +i;
            m.count = 200;
            m.purchasePrice = Math.random() * 100;
            m.soldPrice = (1+Math.random()) * 100;
            all[i] = m;
        }

        System.out.println("请输出毛利润最高的商品：");
        littleSuperMarketV2.getBiggestProfitMerchandise().describe();
    }
}
