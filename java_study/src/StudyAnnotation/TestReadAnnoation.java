package StudyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReadAnnoation {
    public static void main(String[] args) throws NoSuchMethodException {
        //  TODO 读出我使用的注解信息
        Class clazz = TestUseAnnotation.class;
        Method method = clazz.getMethod("test");
        // 遍历打印注解
        for(Annotation annotation : method.getAnnotations()){
            System.out.println(annotation.annotationType());
        }


        // TODO 读取到注解内容（类似于调用了接口的方法），可以根据注解的内容，作为相应功能的配置，来实现相应的功能
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.abc());  // 打印返回的注解内相应属性定义的值，下同
        System.out.println(myAnnotation.defaultValue());
        System.out.println(Arrays.asList(myAnnotation.defaultv()));  // 以列表视图的方式打印出来
        System.out.println(myAnnotation.targetClass());
    }
}
