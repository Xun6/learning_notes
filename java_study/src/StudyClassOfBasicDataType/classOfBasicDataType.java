package StudyClassOfBasicDataType;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * 学习一下基本数据类型的封装类
 */
public class classOfBasicDataType {
    public static void main(String[] args){
        // TODO java为每种基本数据类型提供了封装类，以便可以将其当作类而非基本数据类型来使用
        // TODO 比如 List、Map这些类，都是操作的Object，无法操作基本数据类型

        System.out.println("--------------自动封箱拆箱---------------");
        // TODO 从基本数据类型到封装类，称之为自动封箱，反之叫自动拆箱
        Integer ad = 999;
        int d = ad;

        // TODO 如下自动封箱为 Integer，作为 Map 中的 key
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"壹");
        map.put(2,"贰");
        map.put(3,"叁");
        System.out.println(map.get(1));

        // TODO 自动拆箱为 int，并赋值给 key
        for(int key : map.keySet()){
            System.out.println(key);
        }


        System.out.println("=============有用的方法===============");
        System.out.println(Integer.toBinaryString(1024));  // 转成二进制
        System.out.println(Integer.toOctalString(1024));    // 转成八进制
        System.out.println(Integer.toHexString(1024));  // 转成十六进制

        // TODO 所有与数字相关的封装类，都是继承自 Number 类
        Number number = 9;
        number = new Integer(99);
        Number num = 9.99;
        num = new Double(99.99);

    }


}
