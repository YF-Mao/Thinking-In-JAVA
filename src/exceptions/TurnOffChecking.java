package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/22
 **/
public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new SomeOtherException();
                }
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            }
        }
    }
}

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("where am I?");
                default:
                    return;
            }
        } catch (Exception e) {
            //TODO 5.使用RuntimeException可以将其他异常包装进去，通过getCause()来捕获这里抛出来的异常
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {

}
