package StudyThread.DeadLock;

/**
 * 模拟两个资源
 */
public class AppResources {
    // TODO 模拟系统中的两个资源
    private Object resourcePrint = new Object();
    private Object reourceInput = new Object();

    public Object getResourcePrint() {
        return resourcePrint;
    }

    public Object getReourceInput() {
        return reourceInput;
    }
}
