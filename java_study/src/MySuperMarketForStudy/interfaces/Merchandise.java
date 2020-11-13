package MySuperMarketForStudy.interfaces;

/**
 * 商品接口
 */
public interface Merchandise {
    String getName(); //获取商品名称

    double getSoldPrice(); //获取商品的销售价格

    double getPurchasePrice(); //获取商品的进货价格

    int buy(int count); //购买商品

    void putBack(int count); //放回商品

    int getCount(); //获取商品库存

    Category getGategory();  //获取商品的类别

}
