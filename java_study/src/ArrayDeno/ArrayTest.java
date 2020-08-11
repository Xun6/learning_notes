package ArrayDeno;

public class ArrayTest {
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
        double[] scores = new double[totalScoreCount];
        //创建数组，记录科目
        String[] scoreNames = new String[totalScoreCount];
        //给科目索引赋值
        scoreNames[YuWen] = "语文";
        scoreNames[ShuXue] = "数学";
        scoreNames[YingYu] = "英语";
        scoreNames[WuLi] = "物理";
        scoreNames[HuaXue] = "化学";
        scoreNames[ShengWu] = "生物";

        //给成绩数组元素循环赋值
        for(int i=0; i<totalScoreCount; i++){
            scores[i] = 80 + Math.random() * 20;
            System.out.println(scoreNames[i] + "的成绩为： " + scores[i]);
        }
        //定义一个最大值变量
        double maxScore = 0;
        int index = -1;  //标记

        //求出最大值
        for(int i = 0; i < totalScoreCount; i++){
            if(scores[i] > maxScore){
                maxScore = scores[i];
                index = i;
            }
        }
        System.out.println("最好的成绩是：" + scoreNames[index] +" " + maxScore);

        System.out.println(Math.random());
        /**Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值，
         * 是Java语言常用代码。
         * 例如：double a=Math.random()*(3-1)+1，设置一个随机1到3的变量。
         */
    }
}
