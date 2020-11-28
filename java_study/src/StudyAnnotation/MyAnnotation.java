package StudyAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 我自定义的 注解
 */
// TODO 表示注解可以被用在哪个/哪些元素上（如下表示可用在方法元素上）
@Target(ElementType.METHOD)

// TODO 表示注解会被留存到哪个阶段
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {
    // TODO Annotation支持的类型有基本数据类型、class、String、枚举、其他注解，以上类型的数组
    // TODO 定义时可以指定缺省值
    String defaultValue() default "N/A";

    Class targetClass();

    int abc();

    String[] defaultv();

    // 如下是注解类型
    Override test() default @Override;

}
