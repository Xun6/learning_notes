package MySuperMarketForStudy;

/**
 * 超市的折扣策略接口
 */
public interface DiscountStrategy {
    /**
     * 折扣方法
     * @param shoppingCar 购物车
     * @return  因为此折扣策略所折扣掉的钱
     */
    double discount(ShoppingCar shoppingCar);
}
