package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/10
 **/
public class MyException extends Exception {
    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }
}
