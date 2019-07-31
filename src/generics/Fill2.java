package generics;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(generator.next());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

interface Addable<T> {
    void add(T t);
}

//工作于基类型 Collection

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T t) {
        c.add(t);
    }
}

class Adapter {
    //核心在这里，通过重新创建一个自己的实现接口的类  来存储传递过来的内容
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Coffee.class, 2);

        for (Coffee c : carrier) {
            System.out.println(c);
        }

        System.out.println("---------------------");
        AddableSimpleQueue<Coffee> addableSimpleQueue = new AddableSimpleQueue<>();
        Fill2.fill(addableSimpleQueue, Mocha.class, 4);
        Fill2.fill(addableSimpleQueue, Latte.class, 1);

        for (Coffee c : addableSimpleQueue) {
            System.out.println(c);
        }
    }
}