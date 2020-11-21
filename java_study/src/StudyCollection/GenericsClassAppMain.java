package StudyCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 运用泛型
 * 解决问题：让List中只有一种类型的元素，使用时不用强制类型转换 ！！！
 */
public class GenericsClassAppMain {
    public static void main(String[] args){
//        printList();
        printGenericsList();
    }


    public static List createList(){
        List list = new ArrayList();
        for(int i =0; i < 10; i++){
            list.add("str" + i % 5);
        }
        return list;
    }

    /**
     * 使用泛型来制定类型，相当于告诉java 在List里只有String类型的元素
     * @return
     */
    public static List<String> useGenericsCreateList(){
        List<String> list = new ArrayList<>();
        for(int i =0; i < 10; i++){
            list.add("str" + i % 5);
        }
        return list;
    }

    public static void printList(){
        List str = createList();
        for(int i =0 ;i < str.size(); i++){
            // 需要强制转换类型
            String s = (String) str.get(i);
            s.toUpperCase();  // 转换大写
            System.out.println(s);
        }
    }

    /**
     * 使用泛型指定了元素类型
     */
    public static void printGenericsList(){
        List<String> str = useGenericsCreateList();
        for(int i =0 ;i < str.size(); i++){
            // 需要强制转换类型
            String s = str.get(i).toUpperCase(); // 取出元素，并转换成大写字母
            System.out.println(s);
        }
    }
}
