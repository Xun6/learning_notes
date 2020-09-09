package com.xiaoyu.xiaoChaoShi.supermarket;

/**
 * 一个小超市类
 */
public class LittleSuperMarket {
    public String superMarketName;    //超市名称
    public String address;    //超市地址
    public int parkingCount;   //停车位数量
    public double incomingSum;   //收入总和
    public Merchandise[] merchandises;   //商品数组
    public int[] merchandiseSold;  //对应商品售卖数数组


    public LittleSuperMarket(){

    }

    /**
     * 带参构造方法
     */
    public LittleSuperMarket(String superMarketName,String address,int parkingCount,double incomingSum){
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;
        this.incomingSum = incomingSum;
    }
}
