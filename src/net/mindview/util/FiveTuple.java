package net.mindview.util;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/26
 **/
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth
                + ", " + fifth + ")";
    }
}
