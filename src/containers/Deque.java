package containers;

import java.util.LinkedList;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T t) {
        deque.addFirst(t);
    }

    public void addLast(T t) {
        deque.addLast(t);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
