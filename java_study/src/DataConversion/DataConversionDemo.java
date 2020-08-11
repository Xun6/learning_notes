//：/Users/air/Desktop/study/learning_notes/java_study/src/DataConversion/DataConversionDemo.java
package DataConversion;

/** 这是一个数据强制转换的示例
 * @author XiaoYu
 * @author 13617920171@163.com
 * */
public class DataConversionDemo {
    public static void main(String[] args){
        int intVal = 99;
        long longVal = 19999;
        //强制类型转换
        intVal = (int) longVal;
        System.out.println(intVal);


        int a = 65;
        char b = (char)a;
        System.out.println(b);
    }
} ///：～
