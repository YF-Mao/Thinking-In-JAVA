package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/10
 **/
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("-------------------------------");
        g();
        System.out.println("-------------------------------");
        h();
    }
}
