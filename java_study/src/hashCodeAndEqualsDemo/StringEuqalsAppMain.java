package hashCodeAndEqualsDemo;

import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;

import java.util.Scanner;

/**
 * string对象的equals 和 == 比较
 */
public class StringEuqalsAppMain {
    public static void main(String[] args){
        LittleSuperMarketV7 superMarket7 = new LittleSuperMarketV7("大卖场","杭州萧山机场",
                500,600,100);

        String s1 = "aaabbb";
        String s2 = "aaa" + "bbb";

        //对比判断
        System.out.println("s1 和 s2用==判断结果："+ (s1 == s2));
        System.out.println("s1 和 s2用equals判断结果："+ s1.equals(s2));  //针对字符串一一对比

        // >>TODO 打乱Java对String的优化再试试看（输入字符串要比较长的）
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 a1：");
        String a1 = scanner.nextLine();

        System.out.println("请输入 a2：");
        String a2 = scanner.nextLine();

        System.out.println("a1 和 a2用==判断结果："+ (a1 == a2));
        System.out.println("a1 和 a2用equals判断结果："+ a1.equals(a2));

    }
}
