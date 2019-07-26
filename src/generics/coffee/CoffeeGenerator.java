package generics.coffee;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    //TODO 9.学习下迭代器模式的构造过程，学习内部类使用的思想
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random random = new Random(47);

    public CoffeeGenerator() {

    }

    private int size = 0;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }
}
