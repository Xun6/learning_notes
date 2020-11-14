package ExceptionStudy.MyException;

/**
 * 自定义异常
 */
public class myException extends Exception{


    public myException() {
    }

    public myException(String message) {
        super(message);
    }

    public myException(String message, Throwable cause) {
        super(message, cause);
    }

    public myException(Throwable cause) {
        super(cause);
    }
}
