package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Card;
import MySuperMarketForStudy.interfaces.Customer;
import MySuperMarketForStudy.interfaces.ShoppingCar;

/**
 * 抵扣现金的卡，实现了Card接口
 */
// TODO 思考：怎样使用这个类好呢？
public class CashCard implements Card {

    // TODO 折扣点怎么使用 ？？？？？？？？？

    //实现接口的方法
    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount, Customer customer, ShoppingCar shoppingCar) {
        return 0;
    }
}
