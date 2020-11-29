package StudyLambda;

public class LambdaWithReturnValue {
    public static void main(String[] args) throws Exception {
        String retException = randomDataWithExceptionHandling(String::valueOf);
        System.out.println(retException);

    }


    // TODO lambda 如果有 checked exception 异常，那么接口必须允许。在调用的地方正常处理异常既可
    public static String randomDataWithExceptionHandling(ExceptionLambda<Object,String> converter) throws Exception {
        return converter.hasException(Math.random());
    }

}



// 自己定义的一个接口，可以抛异常
interface ExceptionLambda<P,R>{
    /**
     *
     * @param p  参数类型为 P
     * @return  返回值类型为 R
     * @throws Exception
     */
    R hasException(P p) throws Exception;
}
