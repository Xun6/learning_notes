package StudyAnnotation;

public class TestUseAnnotation {
//    @MyAnnotation(defaultValue = "1234",targetClass = TestUseAnnotation.class,
//            abc = 123,defaultv = {"asd","123"})   // 该注解是作用于方法的，所以在此处使用不合适
    private Object object;


    // TODO 使用自己注解，并给属性赋值
    @MyAnnotation(defaultValue = "1234",targetClass = TestUseAnnotation.class,
            abc = 123,defaultv = {"asd","123"})
    public void test(){

    }
}
