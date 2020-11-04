package extendsDemo;

import comm.StudyClass.Categroy;

public class usePhoneStaticClassAppMain {
    public static void main(String[] args){
        //初始化gift
        Merchandise_V7 giftForPhone = new Merchandise_V7(
                "手机赠品-64G储存卡",
                "GIFT001",
                1,
                120,
                60,
                Categroy.ELECTRIC  //新增枚举类别
        );

        //实例化
        Phone phone = new Phone("手机001","phone001",100,1999,999,
                Categroy.ELECTRIC,4.5,3.5,4,128,"索尼","安卓",
                giftForPhone);
        //调用描述方法
        phone.describePhone();

        //直接实例化静态内部类
        Phone.CPU cpu = new Phone.CPU(4.5,"default");
        System.out.println(cpu.toString());

        Math.random();

    }
}
