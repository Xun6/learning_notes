package MySuperMarketForStudy.util;

import MySuperMarketForStudy.implement.*;
import MySuperMarketForStudy.interfaces.Category;
import MySuperMarketForStudy.interfaces.Customer;
import MySuperMarketForStudy.interfaces.Merchandise;
import MySuperMarketForStudy.interfaces.SuperMarket;

import java.util.Scanner;

/**
 * 工具类
 */
public class ShoppingUtil {
    //定义输入输出静态变量
    private static final Scanner in = new Scanner(System.in);
    //基本输入方法
    public static Scanner input() {
        return in;
    }


    //自定义封装输出方法
    public static void output(Object obj){
        System.out.println(String.valueOf(obj));
    }


    /**
     * 创建 超市
     * @return 超市
     */
    public static SuperMarket createSuperMarket(){
        // 定义每种类别10个商品
        int merchandisePerCategory = 10;
        // 初始化商品存储数组 50 长度
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        // 给每个类别，赋值10个商品
        for(Category category : Category.values()){
            for(int i = 0; i < merchandisePerCategory; i++){
                // 随机初始化 售价
                double soldPrice = Math.random() * (category.getHigherPrice() - category.getLowerPrice()) +
                        category.getLowerPrice();
                // 初始化 进价
                double purchasePrice = soldPrice * 0.7;


                // 初始化每条商品
                all[category.ordinal() * merchandisePerCategory + i] = new SimpleMerchandise(category.name(),soldPrice,
                        purchasePrice,200,category);

            }
//            output(category.ordinal());
        }

        // 实例化超市
        SimpleSuperMarket superMarket = new SimpleSuperMarket(all);
        output("请输入超市的名字：");
        String s = input().next(); // 输入字符串
        // 判断去空格输入长度 大于 0，表示有实际输入
        if(s.trim().length() > 0){
            superMarket.setName(s.trim());
        }
        return superMarket; // 返回超市
    }


    /**
     * 创建 一个新的顾客
     * @param outo  是否自动创建顾客
     * @return
     */
    public static Customer createCustomer(boolean outo){
        if(outo){
            // 随机创建 顾客 ID
            String custId = "CUST" + (int)(Math.random() * 1000);
            //随机获取顾客想购买的商品类别
            Category shouldBuy = getRandomCategory();
            //按随机比例 创建不同的顾客
            if(Math.random() < 0.5){
                return new SuiYuanCustomer(custId,shouldBuy);
            } else {
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(custId,shouldBuy);
                // 随机设置一个等级的会员卡
                ret.setCard(getRandomVIPCard());
                return ret;
            }
        }

        return null; // 不自动创建顾客时，返回null
    }


    // 获取随机的分类
    public static Category getRandomCategory() {
        // 返回 0 ～ 4 的元素
        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
    }

    // 获取随机会员卡级别
    public static VipCard getRandomVIPCard() {
        // 返回 0 ～ 5 的元素
        return VipCard.values()[(int)(Math.random() * VipCard.values().length)];
//        return VipCard.values()[(int) (Math.random() * 1000) % VipCard.values().length];
    }

}
