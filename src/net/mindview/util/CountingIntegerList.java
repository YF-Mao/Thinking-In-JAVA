package net.mindview.util;

import java.util.AbstractList;

/**
 * @description: 只读list
 * @author: YF.Mao
 * @create: 2019/8/14
 **/
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
        CountingIntegerList countingIntegerList = new CountingIntegerList(10);
    }
}
