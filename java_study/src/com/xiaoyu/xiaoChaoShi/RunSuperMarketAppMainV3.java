package com.xiaoyu.xiaoChaoShi;
/**
 * 商品第二件半价
 * */
import com.xiaoyu.xiaoChaoShi.supermarket.LittleSuperMarketV2;
import com.xiaoyu.xiaoChaoShi.supermarket.MerchandiseV2;

import java.util.Scanner;

public class RunSuperMarketAppMainV3 {
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

        //实现逻辑
        Scanner scanner = new Scanner(System.in);

//        while(true){
//            System.out.println("今日超市大促销，所有商品第二件半价，请选择商品索引：");
//            int index = scanner.nextInt();
//
//            //跳出循环
//            if(index < 0){
//                break;
//            }
//            //过滤验证
//            if(index >=all.length){
//                System.out.println("商品索引超出界限了！！！");
//                continue;
//            }
//
//            //取出商品
//            MerchandiseV2 m1 = all[index];
//            System.out.println("商品"+m1.name + "的售价为：" + m1.soldPrice + "，请输入需要购买的商品数量：");
//            int numToBuy = scanner.nextInt();
//
//            //过滤验证
//            if(numToBuy > m1.count){
//                System.out.println("库存不足，请重新选择～");
//                continue;
//            }
//            //计算全价商品数量
//            int fullPriceCount = numToBuy/2 + numToBuy % 2;
//            //计算半价商品数量
//            int halfPriceCount = numToBuy - fullPriceCount;
//            //总的花费
//            double totalCost = fullPriceCount * m1.soldPrice + (halfPriceCount * m1.soldPrice / 2);
//            //计算商品剩余库存
//            m1.count -= numToBuy;
//            System.out.println("选购商品花费的总价为：" + totalCost);
//        }

        MerchandiseV2 m0 = all[0];  //假设我当前的商品 是第0个
        /** 使用封装的方法实现逻辑 */
        while(true){
            System.out.println("今日超市大促销，所有商品第二件半价，请选择商品索引：");
            int index = scanner.nextInt();
            //跳出循环
            if(index < 0){
                break;
            }
            //过滤验证
            if(index >=all.length){
                System.out.println("商品索引超出界限了！！！");
                continue;
            }

            //计算逻辑
            System.out.println("请输入购买商品的数量：");
            int count = scanner.nextInt();
            MerchandiseV2 m2 = all[index];  //选择的商品
            //调用方法，并输出
            System.out.println("我选择的商品价值是最大的：" +
                    m2.isTheBiggestValueOne(littleSuperMarketV2));
            double totalCost = m2.buy(count,true);   //调用 buy()方法
            //比较 m0 和 m2 商品的成本
            boolean m0BigThan = m0.totalValueBiggerThan(m2);  //调用方法
            System.out.println("商品m0 比 商品m2 要大 :" +m0BigThan);
            System.out.println("总消费为：" + totalCost);
        }
    }
}
