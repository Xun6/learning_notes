package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Card;
import MySuperMarketForStudy.interfaces.Category;
import MySuperMarketForStudy.interfaces.HasCard;
import MySuperMarketForStudy.interfaces.Merchandise;

/**
 * ThinkAndBuyCustomer子类顾客，继承absCustomer父类，实现了 hascard 接口
 */
public class ThinkAndBuyCustomer extends absCustomer implements HasCard {

    // 给他一个会员卡
    private Card card = VipCard.Level0;

    /**
     * 构造方法，且继承父类构造方法
     * @param custId
     * @param shouldBuy
     */
    public ThinkAndBuyCustomer(String custId, Category shouldBuy) {
        super(custId, shouldBuy,DEFAULT_GUANG_COUNT);
    }

    @Override //重写父类方法
    public int buyMerchandise(Merchandise merchandise) {
        Category category = merchandise.getGategory();
        //满足想买的商品类型就买一个
        if (category == getShouldBuy()){
            return 1;
        }

        //小于同类商品半价的话再买一个
        double soldPrice = merchandise.getSoldPrice();
        double avgPrice = (category.getHigherPrice() + category.getLowerPrice()) / 2;
        if(soldPrice < avgPrice){
            return 1;
        } else {
            return 0;
        }
    }

    //基本方法

    public void setCard(Card card) {
        this.card = card;
    }

    // 实现接口的方法
    @Override
    public Card getCard() {
        return card;
    }
}
