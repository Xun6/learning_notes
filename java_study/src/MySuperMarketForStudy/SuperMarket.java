package MySuperMarketForStudy;

/**
 * 超市接口
 */
public interface SuperMarket {
    //获取所有商品
    Merchandise[] getAllMerchandise();

    //随机根据分类获取商品
    Merchandise[] getRandomMerchandiseOfCategory(Category category);

    //交易成功获取一笔收益
    void addEarnedMoney(double earnedMoney);

    //每日营业清单
    void dailyReport();
}
