package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Category;
import MySuperMarketForStudy.interfaces.Merchandise;

/**
 * 商品实现类
 */
public class SimpleMerchandise implements Merchandise {
    //定义变量
    private String name;  // 商品名称
    private double soldPrice; // 商品售价
    private double purchasePrice; // 商品进价
    private int count; // 商品库存
    private Category category; // 商品类别

    /**
     * 带参数构造方法
     * @param name
     * @param soldPrice
     * @param purchasePrice
     * @param count
     * @param category
     */
    public SimpleMerchandise(String name,double soldPrice,double purchasePrice,int count,
                             Category category){
        this.name = name;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
        this.count = count;
        this.category = category;
    }


    //实现接口的多有方法
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSoldPrice() {
        return soldPrice;
    }

    @Override
    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public int buy(int count) {
        // TODO 思考：卖超了怎么办 ？
        this.count -= count; // 减掉库存
//        if(this.count - count < 0){
//            System.out.println("库存不足，请选择其他商品吧！！！");
//            return -1;
//        }
        return count;
    }

    @Override
    public void putBack(int count) {
        this.count += count;  //加回库存
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Category getGategory() {
        return category;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
