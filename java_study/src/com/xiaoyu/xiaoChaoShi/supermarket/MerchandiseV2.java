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
}
