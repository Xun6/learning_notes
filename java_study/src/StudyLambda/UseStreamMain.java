package StudyLambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static StudyLambda.StudyLambdaAppMain.addElementsToList;

/**
 * lambda 中的两个使用 Stream 和 collector
 */
public class UseStreamMain {
    public static void main(String[] args){
        List<String> list = addElementsToList(new ArrayList<>());
        System.out.println("------------------lambda的奥义------------------");
        // TODO lambda 的奥义是使用lambda一个接着一个的处理，直到业务结束
        // TODO 理性来说，lambda结构对计算优化是友好的
        list.stream().filter(s -> s.length() > 4).map(String::toUpperCase).forEach(System.out::println);


        // TODO 也可以使用collector让数据重新生成一个List
        System.out.println("----------------------使用collector---------------------------");
        List<String> stringList = list.stream().filter(s -> s.length() > 4).map(String::toUpperCase).
                collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }

}
