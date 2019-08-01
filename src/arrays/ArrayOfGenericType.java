package arrays;

import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/2
 **/
public class ArrayOfGenericType<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //error
        //因为擦除的原因导致无法创建泛型数组
        //array = new T[size];
        array = (T[]) new Object[size];
    }

    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        String[] a2 = new String[size];

        Arrays.fill(a1, true);
        Arrays.fill(a2, "Hello");
        Arrays.fill(a2, 3, 5, "World");
        System.out.println("a1 = " + Arrays.toString(a1));
        System.out.println("a2 = " + Arrays.toString(a2));
    }
}
