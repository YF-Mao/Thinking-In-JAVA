package net.mindview.util;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/26
 **/
public class TwoTuple<A, B> {
    /**
     * final声明能够保护public元素
     *
     */
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
