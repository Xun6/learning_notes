package ExceptionStudy;

/**
 * 会抛出异常的接口
 */
public interface InterfaceWithEx {

    void danger() throws Exception;

    void safe();
}
