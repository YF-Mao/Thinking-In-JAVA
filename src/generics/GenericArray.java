package generics;

import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        //throw java.lang.ClassCastException
        //因为在运行期间泛型会被擦除成Object类型
        //Integer[] ia = gai.rep();
        //System.out.println(ia);
        Object[] oa = gai.rep();
        System.out.println(Arrays.toString(oa));
    }
}
