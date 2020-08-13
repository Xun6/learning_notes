package ArrayDeno;

import java.util.Scanner;

/** 一个程序搞定成绩的各种需求：
 *      1、求某年最好成绩
 *      2、求某年的平均成绩
 *      3、求所有年份最好成绩
 *      4、求某门课历最好成绩
 *      自由发挥。。。*/

public class DoubleDimArrayDemo {
    public static void main(String[] args){
        //创建六个索引变量
        int YuWen = 0;
        int ShuXue = 1;
        int YingYu = 2;
        int WuLi = 3;
        int HuaXue = 4;
        int ShengWu = 5;

        int totalScoreCount = 6;
        //创建数组，记录科目
        String[] scoreNames = new String[totalScoreCount];
        //给科目索引赋值
        scoreNames[YuWen] = "语文";
        scoreNames[ShuXue] = "数学";
        scoreNames[YingYu] = "英语";
        scoreNames[WuLi] = "物理";
        scoreNames[HuaXue] = "化学";
        scoreNames[ShengWu] = "生物";

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入共有多少年成绩：");
        //定义一个年份变量
        int yearCount = scanner.nextInt();

        //创建二维数组
        Double[][] scores = new Double[yearCount][totalScoreCount];
        //给每年的各科目成绩赋值
        for(int i=0; i<yearCount ; i++){
            for(int j=0; j<totalScoreCount;j++ ){
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("第" + (i+1) +"年的" + scoreNames[j] +"成绩为： " + scores[i][j]);
            }
        }

        boolean whileDown = true;  //控制程序结束循环
        //循环
        while(whileDown){
            System.out.println("请输入要进行操作的需求编号：");
            System.out.println("1、求某年最好的成绩\n" +
                    "2、求某年的平均成绩\n" +
                    "3、求所有年份最好成绩\n" +
                    "4、求某门课历年来的最好成绩");

            //输入需求编号
            int demandId = scanner.nextInt();

            //定义一个年份变量
            int year = 0;

            switch(demandId){
                case 1:
                    System.out.println("请输入要求的哪一年的最好成绩：");
                    year = scanner.nextInt() -1; //满足索引
                    //判断
                    if(year < 0 || year >=yearCount){
                        System.out.println("非法的年份");
                        break;
                    }
                    //定义一个最好成绩索引变量
                    int bestOfScoreId = 0;
                    for(int i =1; i< scores[year].length; i++){
                        //判断取最大值
                        if(scores[year][bestOfScoreId] < scores[year][i]){
                            bestOfScoreId = i;
                        }
                    }
                    System.out.println("第"+(year+1)+"年的最好成绩是" + scoreNames[bestOfScoreId]+": "+
                            scores[year][bestOfScoreId]);
                    break;
                case 2:
                    System.out.println("请输入要求的某年的平均成绩：");
                    year = scanner.nextInt() -1; //满足索引
                    //判断
                    if(year < 0 || year >= yearCount){
                        System.out.println("非法的年份");
                        break;
                    }
                    //定义一个变量，存储所有成绩
                    double totalScores = 0;
                    for(int i =0; i<scores[year].length; i++){
                        totalScores += scores[year][i];
                    }
                    System.out.println("第"+ (year+1)+ "年的平均成绩是："+ totalScores/totalScoreCount);
                    break;
                case 3:
                    //定义一个最大值索引变量
                    int bestOfYearScoreId = 0;
                    //二维数组遍历
                    for(int i =0; i <scores.length; i++){
                        for(int j=0; j <scores[i].length; j++){
                            //判断
                            if(scores[year][bestOfYearScoreId] < scores[i][j]){
                                year = i;
                                bestOfYearScoreId = j;
                            }
                        }
                    }
                    System.out.println("第"+ (year+1)+ "年的成绩最好，是："+ scoreNames[bestOfYearScoreId] +" "+ scores[year][bestOfYearScoreId]);
                    break;
                case 4:
                    System.out.println("请输入要查询哪门课历年来的最好成绩：");
                    System.out.println("1、语文\n" +
                            "2、数学\n" +
                            "3、英语\n" +
                            "4、物理\n" +
                            "5、化学\n" +
                            "6、生物");
                    int classId = scanner.nextInt() - 1; //满足索引
                    year = 0;
                    //循环取值,最好成绩替换
                    for(int i =0; i < scores.length; i++){
                        if(scores[year][classId] < scores[i][classId]){
                            year = i;
                        }
                    }
                    System.out.println(scoreNames[classId]+ "历年的最好成绩是第 " + (year+1)+" 年： "+scores[year][classId]);
                    break;
                default:
                    System.out.println("程序结束。");
                    whileDown = false;
            }
        }
    }
}
