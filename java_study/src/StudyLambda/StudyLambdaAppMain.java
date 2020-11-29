package StudyLambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class StudyLambdaAppMain {
    public static void main(String[] args){
        List<String> myList = addElementsToList(new ArrayList<>());
        String outside = "outside String"; // 定义一个局部变量

        // TODO 匿名内部类版，引入 Consumer（此处仅作示例） 接口（此处可以是任意一个接口）
        myList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                processString(outside + s);
            }
        });


        // TODO lambda表达式必须能符合接口中定义的抽象方法，从参数，到返回值，到异常，都必须匹配

        // TODO lambda完整表达式：（参数） -> {代码块}
        // TODO lambda可以使用外部数据，怎么看都和匿名内部类是一样的，如下所示：     /////// 第二种
        myList.forEach(
                (s) -> {
                    processString(outside + s);
                }
        );

        // TODO lambda 单参数，代码单行，简化版写法如下：  //////// 第三种
        myList.forEach(
                (s -> processString(outside + s))
        );

        // TODO lambda 若不使用外部变量，还有方法，使用终极简化版(当不是静态方法，使用引用也可以)，如下：
        myList.forEach(StudyLambdaAppMain::processString);

        // TODO lambda 若明确列表里的元素类型，也允许指定一个参数类型里的一个方法作用引用，如下：
        myList.forEach(String::toUpperCase);


        // TODO 使用Map 两个参数的健值对形式,lambda也可直接表述，如下：
        Map<String,String> myMap = new HashMap<>();
        myMap.put("k1","v1");
        myMap.put("k2","v2");
        myMap.put("k3","v3");
        //
        myMap.forEach((k,v) -> processToString(k,v));
        ////
        myMap.forEach(StudyLambdaAppMain::processToString);


        //=============================================
        myList.forEach(StudyLambdaAppMain::processStr);  // 会抛出异常

    }

    // 向链表中添加元素
    public static List<String> addElementsToList(List<String> list){
        for(int i =0; i < 20; i++){
            list.add("str" + i);
        }
        return list;
    }

    // 打印传的实参值
    private static void processString(String str){
        System.out.println(str);
    }

    private static void processToString(String str1,String str2){
        System.out.println(str1 + " " + str2);
    }

    private static void processStr(String s){
        throw new RuntimeException();
    }
}
