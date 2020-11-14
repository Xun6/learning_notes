package ExceptionStudy;

public class ImplementWithEx implements InterfaceWithEx{


    //实现接口的方法
    @Override
    public void danger() throws Exception {
        // TODO 接口中声明了抛出异常，实现类中可以抛，也可以不抛，抛的话必须是接口声明的类或其子类
        throw new Exception();

    }

    @Override
    public void safe() {
        try {
            throw new Exception();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
