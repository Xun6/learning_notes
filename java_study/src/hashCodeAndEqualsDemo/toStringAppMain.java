package hashCodeAndEqualsDemo;

import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;

import java.util.Scanner;

/**
 * toString方法的运用
 */
public class toStringAppMain {
    public static void main(String[] args){
        LittleSuperMarketV7 superMarket7 = new LittleSuperMarketV7("大卖场","杭州萧山机场",
                500,600,100);

        Merchandise_V7 merchandise_v7 = superMarket7.getMerchandiseOf(100);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("商品100是：").append(merchandise_v7);

        System.out.println(stringBuilder.toString());
        System.out.println(merchandise_v7);

    }
}
