package MySuperMarketForStudy;

import java.util.Arrays;
import java.util.Date;

/**
 * 购物车，类
 */
public class ShoppingCar {
    private Merchandise[] buy; //数组存放顾客购买了的商品
    private int[] count; //对应商品购买的数量
    private int curr; // 已加入了多少个商品
    private int max; // 最多能买多少个商品

    //构造方法,初始化购物车
    public ShoppingCar(int maxTypeToBuy){
        buy = new Merchandise[maxTypeToBuy]; // 加入多少中商品在购物车
        count = new int[maxTypeToBuy];
        max = maxTypeToBuy;
        curr = 0;  //初始化为 0
    }

    //是否能继续往购物车内加入商品
    public boolean canHold(){
        return curr < max;
    }

    // 往购物车增加商品
    public boolean add(Merchandise m,int countToBuy){
        if (!canHold()) {
            return false;
        }
        buy[curr] = m; // 购买了的商品
        this.count[curr] = countToBuy; //对应商品索引的数量
        curr++;
        //调用购买商品
        m.buy(countToBuy);
        return true;
    }

    //计算购物车商品实际售价总和
    public double calculateOriginCost(){
        double ret = 0;
        int pos = -1; //确保索引从 0 开始
        for(Merchandise m : buy){
            pos++;
            if (m == null) {
                continue;
            }
            ret += m.getSoldPrice() * count[pos];
        }
        return ret;
    }

    //重写toString()方法

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("========================\n");
        stringBuilder.append("购物时间:").append(new Date()).append("\n");
        int pos = -1;  //确保索引从 0 开始
        //遍历购物车商品，列出商品清单
        for(Merchandise m : buy){
            pos++;
            //例如：初始化购物车商品数是5，要购买3种商品，有两个就是null的
            if(m == null){
               continue;
            }
            stringBuilder.append(m.getGategory().name()).append("\t").append(m.getName()).append("\t")
                    .append(count[pos]).append("\t").append(m.getSoldPrice() * count[pos]).append("\t");
        }
        stringBuilder.append("应付总金额为：").append(calculateOriginCost()).append("\n");
        stringBuilder.append("==========================");
        return stringBuilder.toString();
    }
}
