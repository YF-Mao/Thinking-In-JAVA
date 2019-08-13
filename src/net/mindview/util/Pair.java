package net.mindview.util;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/2
 **/
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}
