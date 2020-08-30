package com.xiaoyu.xiaoChaoShi.supermarket;

/** 这是一个 商品类 */
public class MerchandiseV4 {
    public String name;  //商品名称
    public String id;   //商品id
    public int count;   //商品数量
    public double soldPrice;   //商品售价
    public double purchasePrice;  //商品进价

    public void describe(){
        double oneIncomming = soldPrice - purchasePrice;
        System.out.println("商品名称为：" + name +"，商品Id是："
                + id + "，库存是： " + count + "，商品售价为："+ soldPrice
                + "，单个毛利润是：" + oneIncomming + ",赠品是" + gift.name + ",价值：" + gift.soldPrice);
    }


    //------------- 新增内容 --------------------
    public MerchandiseV4 gift; //当前类型变量
    //方法一
    public void willOutsideValueChangeIfParameterValueChangeHerePrime(int intVal){
        intVal = 9999;
    }

    //方法二
    public void willOutsideValueChangeIfParameterValueChangeHereRef(MerchandiseV4 m2){
        m2 = gift;
    }

    public double getSoldPrice(){
        return soldPrice;
    }

    public MerchandiseV4 getGiftAndHowCanOutSideChangeIt(){
        return gift;
    }
}
