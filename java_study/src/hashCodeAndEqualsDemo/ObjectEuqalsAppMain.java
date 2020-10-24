package hashCodeAndEqualsDemo;

import comm.StudyClass.Categroy;
import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;

public class ObjectEuqalsAppMain {
    public static void main(String[] args){
        int defaultCount = 200;
        LittleSuperMarketV7 superMarket7 = new LittleSuperMarketV7("大卖场","杭州萧山机场",
                500,600,defaultCount);

        Merchandise_V7 t0 = new Merchandise_V7(
                "商品" + 0,
                "ID" + 0,
                defaultCount,
                1999,
                999,
                Categroy.FOOD  //新增枚举属性
        );

        Merchandise_V7 t10 = new Merchandise_V7(
                "商品" + 10,
                "ID" + 10,
                defaultCount,
                1999,
                999,
                Categroy.ELECTRIC
        );

        Merchandise_V7 t100 = new Merchandise_V7(
                "商品" + 100,
                "ID" + 100,
                defaultCount,
                1999,
                999,
                Categroy.ELECTRIC
        );

        //TODO 查看打印结果
        System.out.println(superMarket7.findMerchandise(t0));
        System.out.println(superMarket7.findMerchandise(t10));
        System.out.println(superMarket7.findMerchandise(t100));
    }
}
