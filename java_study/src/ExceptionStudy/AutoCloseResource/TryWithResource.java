package ExceptionStudy.AutoCloseResource;

/**
 * 自动回收资源的 try语句
 */
public class TryWithResource {
    public static void main(String[] args){
        try(
                MyAutoCloseResource read1 = new MyAutoCloseResource("资源1");
                MyAutoCloseResource read2 = new MyAutoCloseResource("资源2")){
            while(true){
                System.out.println(read1.read());
                System.out.println(read2.read());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
