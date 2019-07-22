package holding;

import java.util.Arrays;

/**
 * @description: foreach 与迭代器
 * @author: YF.Mao
 * @create: 2019/7/9
 **/
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        test(Arrays.asList(strings));
    }
}
