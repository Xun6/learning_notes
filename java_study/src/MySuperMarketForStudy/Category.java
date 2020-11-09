package MySuperMarketForStudy;

/**
 * 商品种类，枚举类
 */
public enum Category {
    //实例化枚举
    FOOD(10,300),
    COOK(200,2000),
    SNACK(5,100),
    CLOTHES(200,1000),
    ELECTRIC(200,10000);

    int lowerPrice;
    int higherPrice;

    //构造方法
    Category(int lowerPrice,int higherPrice){
        this.lowerPrice = lowerPrice;
        this.higherPrice = higherPrice;
    }

    //基本getter/setter方法

    public int getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(int lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public int getHigherPrice() {
        return higherPrice;
    }

    public void setHigherPrice(int higherPrice) {
        this.higherPrice = higherPrice;
    }
}
