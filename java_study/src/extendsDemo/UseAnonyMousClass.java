package extendsDemo;

import comm.StudyClass.Categroy;

public class UseAnonyMousClass {
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

        //方法调用
        printSpec(phone.getCpuu());

        //TODO 匿名类实例作为参数也没有问题
        printSpec(new UnitSpec() {
            @Override
            public double getNumSpec() {
                return 110;
            }

            @Override
            public String getProducer() {
                return "new as a argument";
            }
        });

    }

    //======方法封装======
    private static void printSpec(UnitSpec spec){
        System.out.println("spec Producer = " + spec.getProducer() + ". Num = " + spec.getNumSpec());
    }
}
