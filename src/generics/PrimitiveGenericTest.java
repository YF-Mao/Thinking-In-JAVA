package generics;

import net.mindview.util.Generator;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/30
 **/
public class PrimitiveGenericTest {
    public static void main(String[] args) {
        //TODO
        //String[] strings = FArray.fill(new String[7], new Gent)
    }
}

class FArray {
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.next();
        }
        return a;
    }
}
