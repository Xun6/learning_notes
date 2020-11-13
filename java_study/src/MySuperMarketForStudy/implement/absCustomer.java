package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Category;
import MySuperMarketForStudy.interfaces.Customer;
import MySuperMarketForStudy.interfaces.Merchandise;
import MySuperMarketForStudy.interfaces.ShoppingCar;

import static MySuperMarketForStudy.util.ShoppingUtil.getRandomCategory;

/**
 * 顾客抽象类，实现了顾客接口
 */
public abstract class absCustomer implements Customer {
    //定义变量
    private String custId; // 顾客ID
    private double moneySpent; // 花费
    private int guangLeft = 0; // 还能逛几次商品
    private int guangCount = 0; // guangLeft 的初始值
    private Category shouldBuy; // 想买那种类别的商品

    public static final int DEFAULT_GUANG_COUNT = 5;  // 默认逛商品次数 5

    /**
     * 带参数的构造方法
     * @param custId  顾客ID
     * @param shouldBuy 想购买的商品类型
     * @param guangCount 逛商品的次数
     */
    public absCustomer(String custId,Category shouldBuy,int guangCount){
        this.custId = custId;
        this.shouldBuy = shouldBuy;
        this.guangCount = guangCount;
    }

    /**
     * 带参数构造方法 2
     * @param custId 顾客ID
     * @param shouldBuy 想买的商品种类
     */
    public absCustomer(String custId,Category shouldBuy){
        this(custId,shouldBuy,DEFAULT_GUANG_COUNT);
    }

    //基本方法
    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    public Category getShouldBuy() {
        return shouldBuy;
    }

    public void setShouldBuy(Category shouldBuy) {
        this.shouldBuy = shouldBuy;
    }

    // 实现接口的方法
    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount; //重新赋值 逛的商品次数
    }

    /**
     *   选择自己想买什么类型的商品
     * @return 自己想买的 类型的商品
     */
    @Override
    public Category chooseCategory() {
        // 留一次机会看自己想买的类型商品
        if(guangLeft + 1 > guangCount){
            return shouldBuy;
        } else {
            // 否则 随机
            return getRandomCategory();
        }
    }

//    @Override
//    public int buyMerchandise(Merchandise merchandise) {
//        return 0;
//    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft <= 0;
    }

    @Override
    public double payFor(ShoppingCar shoppingCar, double totalCost) {
        moneySpent += totalCost; // 总的花费
        return totalCost;  //返回 花费多少钱
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }
}
