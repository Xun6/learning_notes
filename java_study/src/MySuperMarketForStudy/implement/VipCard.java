package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Card;
import MySuperMarketForStudy.interfaces.Customer;
import MySuperMarketForStudy.interfaces.ShoppingCar;

/**
 * 枚举类 ，实现了 Card 接口
 */
public enum VipCard implements Card {
    // 实例化 折扣
    Level0(1),
    Level1(0.99),
    Level2(0.88),
    Level3(0.78),
    Level4(0.69),
    Level5(0.50);


    // 定义折扣变量
    private double discount;

    /**
     * 构造方法，带参数
     * @param discount  折扣
     */
    VipCard(double discount){
        this.discount = discount;
    }


    //实现接口的方法
    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCar shoppingCar) {
        return totalCostAfterDiscount * (1 - discount); //折扣后，节省的金额
    }
}
