package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Category;
import MySuperMarketForStudy.interfaces.Merchandise;

/**
 * SuiYuanCustomer子类，继承 absCustomer 父类
 */
public class SuiYuanCustomer extends absCustomer{

    private static final double MUST_BUY_CHANCE = 0.8;
    private static final double GUANG_BUY_CHANDE = 0.1;

    /**
     * 构造方法，且调用父类的构造方法
     * @param custId
     * @param shouldBuy
     */
    public SuiYuanCustomer(String custId, Category shouldBuy) {
        super(custId, shouldBuy,DEFAULT_GUANG_COUNT);
    }

    @Override //重写父类方法
    public int buyMerchandise(Merchandise merchandise) {
        //购买一个商品的概率
        double chanceToBuy = merchandise.getGategory() == getShouldBuy() ?
                MUST_BUY_CHANCE : GUANG_BUY_CHANDE;

        //看缘分，买一个或者多个
        if (chanceToBuy < Math.random()){
            return 0;
        } else {
            return 1 + (int)(Math.random() * 3);
        }
    }
}
