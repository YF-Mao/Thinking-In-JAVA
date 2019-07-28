package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] creat(int size) {
        //这个方法适用于在泛型中创建数组
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<>(String.class);
        String[] strings = stringArrayMaker.creat(9);
        System.out.println(Arrays.toString(strings));
    }
}
