package ArrayDeno;

import java.util.Scanner;

/** 二维数组实例 */
public class DoubleDimArray {
    public static void main(String[] args){
        //创建六个索引变量
        int YuWen = 0;
        int ShuXue = 1;
        int YingYu = 2;
        int WuLi = 3;
        int HuaXue = 4;
        int ShengWu = 5;

        //创建数组记录 成绩
        int totalScoreCount = 6;
//        double[] scores = new double[totalScoreCount];
        //创建数组，记录科目
        String[] scoreNames = new String[totalScoreCount];
        //给科目索引赋值
        scoreNames[YuWen] = "语文";
        scoreNames[ShuXue] = "数学";
        scoreNames[YingYu] = "英语";
        scoreNames[WuLi] = "物理";
        scoreNames[HuaXue] = "化学";
        scoreNames[ShengWu] = "生物";

        Scanner in = new Scanner(System.in);
        System.out.println("请问要保存几年的成绩呢？");
        int years = in.nextInt();

        //创建二维数组，保存每年的成绩
        double[][] scoresPerYear = new double[years][scoreNames.length];
        for(int i=0 ; i < years; i++){
            for(int j =0; j < scoreNames.length; j++){
                scoresPerYear[i][j] = 80 + Math.random() * 20;
            }
        }

        System.out.println("请问你要查第几年的成绩呀 ？");
        int year = in.nextInt() - 1;  //保证获取到索引 0

        System.out.println("请输入要查看的课程编号：");
        int scoreIndex = in.nextInt() - 1;

        System.out.println("第"+(year+1)+"年的" + scoreNames[scoreIndex] +"成绩是："
                +scoresPerYear[year][scoreIndex]);
    }
}
