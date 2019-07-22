package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/10
 **/
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(), e.printStackTrace()");
            e.printStackTrace(System.out);
            //TODO 1.原来异常发生点的信息会丢失，变成新的异常发生地了，
            //即在下一个异常堆栈打印的时候只会打印到这里
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main:printStackTrace()");
            e.printStackTrace(System.out);
        }

        System.out.println("========================");
        try {
            f();
        } catch (Exception e) {
            System.out.println("main:printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
