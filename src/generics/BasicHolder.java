package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
