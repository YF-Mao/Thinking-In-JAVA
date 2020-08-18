package generics;

import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class Holder<T> {
    private T value;
    private T[] values;

    public Holder() {

    }

    public Holder(T value) {
        this.value = value;
        values = (T[]) Arrays.asList(value).toArray();
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public T[] getArrays() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        //wrong
        //fruit.set(new Apple());
        System.out.println(fruit.equals(d));
    }
}
