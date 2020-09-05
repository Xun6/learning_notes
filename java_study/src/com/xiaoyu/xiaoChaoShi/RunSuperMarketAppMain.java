package com.xiaoyu.xiaoChaoShi;

import com.xiaoyu.xiaoChaoShi.person.Customer;
import com.xiaoyu.xiaoChaoShi.supermarket.LittleSuperMarket;
import com.xiaoyu.xiaoChaoShi.supermarket.Merchandise;

import java.util.Scanner;

/**
 * @author xiaoyu
 */

public class RunSuperMarketAppMain {
    public static void main(String[] args){
        //实例化小超市
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.address = "杭州滨江阿里中心666号";
        littleSuperMarket.superMarketName = "小鱼超市";
        littleSuperMarket.parkingCount = 300;
        littleSuperMarket.merchandises = new Merchandise[200];  //初始化 200 个商品
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];  //相同索引下商品售卖数量

        //给商品遍历赋值
        Merchandise[] all = littleSuperMarket.merchandises;
        for(int i =0; i<all.length; i++){
            //实例化商品类
            Merchandise m = new Merchandise();
            m.count = 200;
            m.name = "商品"+i;
            m.id = "ID"+i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1+Math.random()) * 200;
            all[i] = m; //赋值给商品数组
        }

        System.out.println("小超市要开张了！！！");

        //是否开始营业
        boolean open = true;
        Scanner scanner = new Scanner(System.in);
        while(open){
            //店铺基本信息介绍
            System.out.println("本店名称 "+ littleSuperMarket.superMarketName);
            System.out.println("本店地址 "+ littleSuperMarket.address);
            System.out.println("本店停车位有 "+ littleSuperMarket.parkingCount + " 个");
            System.out.println("本店商品数量 "+ littleSuperMarket.merchandises.length + "种");
            System.out.println("今日总营业额为 "+ littleSuperMarket.incomingSum);

            //实例化顾客类
            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 10000));
            customer.money = (1 + Math.random()) * 1000;  //1000~2000
            customer.isDrivingCar = Math.random() >0.5;  //是否开车

            //判断车位是否足够
            if(customer.isDrivingCar){
                if(littleSuperMarket.parkingCount > 0){
                    System.out.println("欢迎" + customer.name +"驾车而来。车位充足，请放心停车！车位编号为"+littleSuperMarket.parkingCount);
                    littleSuperMarket.parkingCount--;  //车位减 1
                }else{
                    System.out.println("本店车位满，欢迎下次光临！");
                    continue;
                }
            }else{
                //未驾车
                System.out.println("欢迎" + customer.name + "光临本店！！！");
            }

            //用户购买商品
            double totalCost = 0;  //用户总花费
            while(true){
                System.out.println("本店提供" + all.length +"种商品，欢迎选购。请输入商品编号：");
                int index = scanner.nextInt();

                //结束循环
                if(index < 0){
                    break;
                }
                //过滤输入不能超过数组长度
                if(index >=all.length){
                    System.out.println("本店暂无该商品！请输入编号为 0～" + (all.length-1)+"范围的商品。");
                    continue;
                }

                Merchandise m = all[index];   //取出商品

                System.out.println("您选购的商品名称为："+ m.name +
                        "，单价是："+ m.soldPrice + "，请问您要购买多少个？");
                int numToBuy = scanner.nextInt();

                //过滤购买数量输入负值
                if(numToBuy <= 0){
                    System.out.println("瞧一瞧，看一看，请继续选购：");
                    continue;
                }
                //过滤选购数超过商品库存
                if(numToBuy > m.count){
                    System.out.println("该商品库存不足，欢迎继续选购：");
                    continue;
                }
                //过滤用户金额不足
                if(numToBuy * m.soldPrice + totalCost > customer.money){
                    System.out.println("您带的金额不够，欢迎继续选购：");
                    continue;
                }

                //用户总花费
                totalCost += numToBuy * m.soldPrice;
                //更新商品库存
                m.count -= numToBuy;
                //更新售卖数量
                littleSuperMarket.merchandiseSold[index] += numToBuy;
            }

            //用户离店清点结算
            customer.money -= totalCost;
            System.out.println("这位" + customer.name + "共消费了 "+ totalCost);
            //更新车位
            if(customer.isDrivingCar){
                littleSuperMarket.parkingCount++;
            }
            //店铺收益
            littleSuperMarket.incomingSum += totalCost;

            //是否继续营业
            System.out.println("还要继续营业吗？，请输入true or false ");
            open = scanner.nextBoolean();
        }

        //小超市打烊了
        System.out.println("小超市打烊了！！！");
        System.out.println("今日营业额为：" + littleSuperMarket.incomingSum
                +"，\n销售情况如下：");
        //商品销售情况
        for(int i= 0; i<littleSuperMarket.merchandiseSold.length; i++){
            Merchandise m = all[i]; //对应索引下的商品
            int numSold = littleSuperMarket.merchandiseSold[i]; //对应索引下的商品售卖数
            //过滤掉未产生交易的商品
            if(numSold > 0){
                //单个商品的收入
                double incomming = m.soldPrice * numSold;
                double netIncomming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "卖出了" + numSold +"个，销售额为 "+ incomming
                        +"，净利润为 "+ netIncomming);
            }
        }
    }
}







