package arrays;

import java.util.Comparator;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);

        ints2 = MethodParameter.f(ints);
        doubles = MethodParameter.f(doubles);

        Integer[] a = new Integer[]{1};
        //数组不会进行自动拆装箱

        //int[] a1 =  a;
    }
}

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}
