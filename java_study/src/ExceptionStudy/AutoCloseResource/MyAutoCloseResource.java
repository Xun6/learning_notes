package ExceptionStudy.AutoCloseResource;

import java.io.IOException;

public class MyAutoCloseResource implements AutoCloseable{
    private String resourceName; // 资源的名称
    private int count; // 计数器


    // 构造方法
    public MyAutoCloseResource(String resourceName){
        this.resourceName = resourceName;
    }

    // 简单的读取方法
    public String read() throws IOException {
        count++; // 计数
        if(Math.random() > 0.1){
            return "You got lucky to read from" + resourceName + " for " + count + " time";
        } else {
            throw new IOException("resource不存在啊 ！！！"); // 抛异常
        }
    }


    //  实现接口的方法
    @Override
    public void close() throws Exception {
        System.out.println("资源释放了：" + resourceName);
    }
}
