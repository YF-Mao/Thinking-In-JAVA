package generics;

import java.util.Iterator;

/**
 * @description: 我自己写的一个关于Fibonacci类的适配类，使用组合的方式来做适配
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public class MyIterableFibonacci implements Iterable<Integer> {
    private Fibonacci fibonacci;
    private Integer count = 0;

    public MyIterableFibonacci(Fibonacci fibonacci, Integer count) {
        this.fibonacci = fibonacci;
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Integer next() {
            count--;
            return fibonacci.next();
        }
    }

    public static void main(String[] args) {
        for (int i : new MyIterableFibonacci(new Fibonacci(), 18)) {
            System.out.print(i + " ");
        }
    }
}
