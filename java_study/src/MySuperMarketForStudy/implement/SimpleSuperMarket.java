package MySuperMarketForStudy.implement;

import MySuperMarketForStudy.interfaces.Category;
import MySuperMarketForStudy.interfaces.Merchandise;
import MySuperMarketForStudy.interfaces.SuperMarket;

import static MySuperMarketForStudy.util.ShoppingUtil.output;

/**
 * 超市实现类
 */
public class SimpleSuperMarket implements SuperMarket {
    //定义几个局部变量
    private String name = "无名";
    private Merchandise[] all; // 存储所有商品
    private int[] allCount; // 存储每一种商品的原始数量
    private double totalMoneyEarn;  // 营业额（收入的钱）
    private int customerCount; //共服务过多少顾客，可用在 dailyReport中


    /**
     * 构造方法
     * 初始化每个商品的原始库存数
     * @param all 传入所有商品
     */
    public SimpleSuperMarket(Merchandise[] all){
        this.all = all;
        allCount = new int[all.length];
        // 初始化每个商品的库存数
        for(int i = 0;i < all.length; i++){
            allCount[i] = all[i].getCount();
        }
    }


    //实现接口的所有方法
    @Override
    public Merchandise[] getAllMerchandise() {
        return all;
    }

    @Override
    public Merchandise[] getRandomMerchandiseOfCategory(Category category) {
        Merchandise[] ret = new Merchandise[5]; // 初始化，默认存储五个同类商品
        int index = 0; // 初始化索引 0
        //循环遍历商品,挑选出来
        for(Merchandise m : all){
            // 判断条件
            if(m.getGategory() == category && Math.random() > 0.5 && index < ret.length - 1){
                ret[index] = m;  //赋值
                index++;
            }
        }
        return ret;
    }

    @Override
    // 完成一单
    public void addEarnedMoney(double earnedMoney) {
        customerCount++; // 服务的顾客 +1
        this.totalMoneyEarn += earnedMoney; // 营业额额增加
    }

    @Override
    public void dailyReport() {
        output("营业额为：" + totalMoneyEarn);
        output("商品售出情况如下：");
        for(int i =0; i < all.length; i++){
            if(allCount[i] != all[i].getCount()){
                System.out.println(all[i].getGategory().name() + "\t" + all[i].getName() + "\t" +
                        (allCount[1] - all[i].getCount()));
            }
        }
    }

    //基本方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
