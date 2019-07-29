package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static <T> void add(List<? extends T> list, T item) {
        //list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();

    static void f1() {
        fruits.add(new Apple());
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
    }

    //使用超类型通配符，就可以安全地将一个T类型的对象或者从T导出的任何对象作为参数传递给List的方法
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }

    public static void main(String[] args) {
        f1();
        System.out.println(fruits);
        System.out.println(apples);
        f2();
    }
}
