package com.xiaoyu.xiaoChaoShi.supermarket;

public class Merchandise_V6 {
    public String name;  //商品名称
    public String id;   //商品id
    public int count;   //商品数量
    public double soldPrice;   //商品售价
    public double purchasePrice;  //商品进价

    //设置静态变量，打95折
    public static double DISCOUNT_FOR_VIP = 0.95;

    /**
     *
     * @param name  外部传递的商品名称
     * @param id
     * @param count
     * @param soldPrice
     * @param purchasePrice
     */
    public void init(String name,String id,int count,double soldPrice,double purchasePrice){
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public void descript(){
        System.out.println("商品名称为：" + name +"，商品Id是："
                + id + "，库存是： " + count + "，商品售价为："+ soldPrice
                + "，单个进价为：" + purchasePrice +"，单个毛利润为：" + (soldPrice-purchasePrice)+
                ",折扣为：" + DISCOUNT_FOR_VIP);
    }

    // >> TODO 方法的重载，重载的方法可以调用别的重载方法
    //    TODO 方法签名 = 方法名 + 参数类型
    //买一个
    public double buy(){
        return buy(1);
    }

    //买多个
    public double buy(int count){
        return buy(count,false);
    }

    //买多个，有会员打 95折
    public double buy(int count,boolean isVIP){
        if(this.count < count){
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if(isVIP){
            return totalCost * DISCOUNT_FOR_VIP;
        } else {
            return totalCost;
        }
    }
}
