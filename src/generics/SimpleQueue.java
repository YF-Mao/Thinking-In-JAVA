package generics;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class SimpleQueue<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }

    private LinkedList<T> storage = new LinkedList<>();

    public T get() {
        return storage.poll();
    }

    public void add(T item) {
        storage.offer(item);
    }
}
