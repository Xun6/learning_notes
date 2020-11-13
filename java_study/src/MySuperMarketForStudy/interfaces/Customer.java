package MySuperMarketForStudy.interfaces;

/**
 * 顾客接口
 */
public interface Customer {
    String getCustId(); // 获取顾客ID

    /**
     * 开始购物前准备
     */
    void startShopping();

    /**
     * @return 顾客想购买的商品种类
     */
    Category chooseCategory();

    /**
     * 顾客是否要购买此商品
     * @param merchandise 是否要购买的商品
     * @return 购买商品的数量
     */
    int buyMerchandise(Merchandise merchandise);

    /**
     *  顾客是否购买后，要结账
     * @return true：要结账，false：继续逛
     */
    boolean wantToCheckout();

    /**
     * 付款
     * @param shoppingCar 此次购买商品的购物车
     * @param totalCost 经过折扣策略后的总价
     * @return 成功支付返回支付的钱，否则返回 -1
     */
    double payFor(ShoppingCar shoppingCar,double totalCost);

    /**
     *
     * @return 顾客花费的钱
     */
    double getMoneySpent();
}
