package comm.StudyClass;

import java.util.Scanner;

public class UseEnumAppMain {
    public static void main(String[] args){
        //TODO 获取所有的枚举，使用 values()方法 ,返回枚举的数组
        for(Categroy categroy : Categroy.values()){
            System.out.println("------" + categroy.getId() + "--------");
            System.out.println(categroy.ordinal()); //输出枚举的序号
            System.out.println(categroy.name()); //打印出枚举的名字
            System.out.println(categroy.toString());
        }

        System.out.println();
        //TODO 根据名称获取枚举
        System.out.println(Categroy.valueOf("FOOD"));  //会调用toString() 方法

        //获取用户输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入枚举：");
        String enumInput = input.next();
        Categroy enumName = Categroy.valueOf(enumInput.trim().toUpperCase());  //去空格，转换成大写字母
        System.out.println("枚举的信息为：" + enumName.toString());
    }
}
