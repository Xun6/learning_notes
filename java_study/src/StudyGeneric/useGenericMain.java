package StudyGeneric;


import java.lang.reflect.Field;

// TODO 泛型的作用：1、告诉编译器帮我们检查类型是否匹配，要保持一致
// TODO           2、在使用的地方悄悄帮我们做了强制类型转换
public class useGenericMain {
    public static void main(String[] args) throws NoSuchFieldException {
        //反射
        Field field = MyGenericClass.class.getDeclaredField("first");
        System.out.println("first的类型是：" + field.getType());


        // 实例化
        MyGenericClass<String,Object> test1 = new MyGenericClass<>("test1",new Object());
        MyGenericClass test2 = new MyGenericClass("test2","hahah");

        String str = test1.getFrist();
        System.out.println(str);

        // 方法类型参数也是一样，换到实际使用的地方做了一次强制转换
        String another = test1.getAnother("obj");
//        String another = test1.getAnother(new Object());  // 会报错

        // TODO 若果泛型信息缺失，编译器也无法帮忙检查出类型匹配，只能给出 unchecked 编译警告
        MyGenericClass mg = new MyGenericClass("","");

    }
}
