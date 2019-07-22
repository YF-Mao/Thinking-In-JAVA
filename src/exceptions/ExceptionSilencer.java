package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/19
 **/
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
