package net.mindview.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/28
 **/
public class Sets {
    /**
     * 返回a和b的并集
     *
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 返回a和b的交集
     *
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 返回a和b的差集
     *
     */
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    /**
     * 返回a和b的并集  和  a和b的交集   的差集
     *
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
