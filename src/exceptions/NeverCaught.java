package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/15
 **/
public class NeverCaught {
    static void f() {
        //TODO 3.RuntimeException及其子类属于错误，将被编译器自动捕获
        //，不需要异常说明
        throw new RuntimeException();
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
