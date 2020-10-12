package com.xiaoyu.xiaoChaoShi.supermarket;

/** 这是一个 商品类 */
public class MerchandiseV2 {
    public String name;  //商品名称
    public String id;   //商品id
    public int count;   //商品数量
    public double soldPrice;   //商品售价
    public double purchasePrice;  //商品进价
 
    public void describe(){
        double oneIncomming = soldPrice - purchasePrice;
        System.out.println("商品名称为：" + name +"\n商品Id是："
                + id + "\n库存是： " + count + "\n商品售价为："+ soldPrice
                + "\n单个毛利润是：" + oneIncomming);
    }

    //计算毛利润
    public double calculateProfit(){
        double profit = soldPrice - purchasePrice;
        if(profit <= 0){
            return 0;
        }
        return profit;
    }


    //---------------------- 带参数方法的使用------------------------
    // >>TODO 参数是定义在方法名字后面的括号里的
    // >>TODO 参数定义的规范和变量一样，都是类型名称加标识符，这里的标识符我们叫他 参数名
    // >>TODO 方法体中的代码可以使用参数
    // >>TODO 参数值在调用方法的时候需要给出，有的资料叫实参（实际参数）
    //   TODO 方法定义时的参数叫 形参（形式参数）

    //购买商品数，第二件半价商品总花费
    //如果返回值是负数，就表示购买失败，比如库存不足
    //传多个参数
    public double buy(int countToBuy,boolean printLeft){
        //过滤验证
        if(countToBuy > count){
            System.out.println("库存不足！");
            //打印库存
            if(printLeft){
                System.out.println("库存为：" + count);
            }
            return -1;
        }

        System.out.println("商品的价格为 " + soldPrice);
        //花费计算逻辑
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = fullPriceCount * soldPrice + (halfPriceCount * soldPrice / 2);
        //商品剩余库存
        count -= countToBuy;
        if(printLeft){
            System.out.println("剩余库存为：" + count);
        }
        return totalCost;
    }


    //---------------- 带引用变量参数的方法 ---------------------
    // >>TODO 参数可以是任何类型，包括自定义类型，甚至是自己的类型都没有问题
    //比较当前我的成本 和 传进来的商品成本相比
    public boolean totalValueBiggerThan(MerchandiseV2 merchandiseV2){
        return count * purchasePrice > merchandiseV2.count * merchandiseV2.purchasePrice;
    }


    //比较我购买的商品是不是 超市里的价值最高的商品
    public boolean isTheBiggestValueOne(LittleSuperMarketV2 littleSuperMarketV2){
        //遍历取商品
        for(int i=0; i<littleSuperMarketV2.merchandises.length; i++){
            MerchandiseV2 merchandiseV2 = littleSuperMarketV2.merchandises[i];
            //比较当前对象的商品成本 和 超市内的商品成本
            if(count * purchasePrice < merchandiseV2.count * merchandiseV2.purchasePrice){
                return false;
            }
        }
        return true;
    }
}
