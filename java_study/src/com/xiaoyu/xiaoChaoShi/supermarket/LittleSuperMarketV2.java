package com.xiaoyu.xiaoChaoShi.supermarket;

/** 一个小超市类 */
public class LittleSuperMarketV2 {
    public String superMarketName;    //超市名称
    public String address;    //超市地址
    public int parkingCount;   //停车位数量
    public double incomingSum;   //收入总和
    public MerchandiseV2[] merchandises;   //商品数组
    public int[] merchandiseSold;  //对应商品售卖数数组


    //实例：让超市找出利润最高的商品
    // >> TODO 返回值类型可以是类名，这时候实际返回的值就是这个类的引用
    public MerchandiseV2 getBiggestProfitMerchandise(){
        MerchandiseV2 curr = null;  //初始一个当前商品值
        //遍历商品
        for( int i =0; i<merchandises.length; i++){
            MerchandiseV2 m = merchandises[i];  //商品变量，动态遍历赋值
            //判断curr==null 时，不需要比较了，m就是最大
            if(curr ==null){
                curr = m;
            }else {
                //否则比较毛利润
                if(curr.calculateProfit() < m.calculateProfit()){
                    curr = m;
                }
            }
        }
        return curr;
    }
}
