package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class GenericReading {
    //只局限于这个方法，泛型类型和类无关
    static <T> T readExacting(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple a = readExacting(apples);
        Fruit f = readExacting(fruits);
        f = readExacting(apples);
    }

    //这是一个泛型类，在创建实例时就要为这个类确定参数，需要确切类型
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruits);

        //fruitReader.readExact(apples);
        Reader<Apple> appleReader = new Reader<>();
        Fruit a = appleReader.readExact(apples);
    }

    //虽然也是泛型类，但是方法接受参数的扩展类
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<>();
        Fruit f = fruitCovariantReader.readCovariant(fruits);
        Fruit a = fruitCovariantReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
