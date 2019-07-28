package generics;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<?> c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1.getSimpleName());
        System.out.println(Arrays.toString(c1.getTypeParameters()));
        System.out.println(c2.getTypeParameters());
        System.out.println(c1 == c2);
    }
}
