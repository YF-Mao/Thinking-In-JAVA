package net.mindview.util;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class Tuple {
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }
}
