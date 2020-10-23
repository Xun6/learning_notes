package comm.StudyClass;

import extendsDemo.LittleSuperMarketV7;
import extendsDemo.Merchandise_V7;
import extendsDemo.ShellColorChangePhone;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 初探 Class 类
 */
public class ClassOfAppMain {
    //设置main方法动态参数 （String...），只能放在最后一个参数位，调用方法传参时，可以不传
    public static void main(String... args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
        LittleSuperMarketV7 superMarket7 = new LittleSuperMarketV7("大卖场","杭州萧山机场",
                500,600,100);

        Merchandise_V7 m100 = superMarket7.getMerchandiseOf(100);
        //TODO Object类里的 getClass 方法
        Class clazz = m100.getClass();
        Class cla = Merchandise_V7.class;
        //以下是第二种实现 instance的方法形式
//        Class clazz = ShellColorChangePhone.class;

//        System.out.println(clazz.getName());
//        System.out.println(clazz.getSimpleName());

        //TODO 通过一个类的 class实例，可以获取一个类的所有信息，包括成员变量，方法等
        Field countField = clazz.getField("count");
        System.out.println(countField.getType());

        //---------------初探反射（上）--------------
//        Field countFie = cla.getField("count");
//        System.out.println(countFie.get(m100)); // 反射调用
//        countFie.set(m100,999); //给 count重新赋值
//        System.out.println(countFie.get(m100));
//        System.out.println(m100.count);  //直接类名调用
        //静态变量反射
        Field field = clazz.getField("STATIC_MEMBER");
        System.out.println(field.get(null));  //反射静态变量值，直接传个null

        //调用静态方法
//        printFiels(cla);


        //TODO 变长参数和他的等价形式
        Method buyMethod = clazz.getMethod("buy", int.class);
        Method equalsMethod = clazz.getMethod("equals", Object.class);
    }

    /**
     * getFields方法，遍历取field值
     * @param clas
     */
    public static void printFiels(Class clas){
        System.out.println(clas.getName()+ "里的Fields");
        for(Field field : clas.getFields()){
            //循环输出,private修饰的成员变量不能够获取到
            System.out.println(field.getType() +" "+ field.getName());
        }
    }
}
