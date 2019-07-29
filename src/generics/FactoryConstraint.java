package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class FactoryConstraint {
    public static void main(String[] args) {
        /**
         * 1.使用Class的内建工厂方法 newInstance() 来创建泛型对象，如果没有默认构造器，会有运行时异常的产生。
         * 2.只是传递Class的一种变体，都传递了工厂对象。如下是创建了一个显式的工厂对象，却获得了编译期检查
         * 3.使用模板方法，让子类来定义create()方法和产生子类类型的对象
         *
         */
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new Widget.Factory());
    }
}

interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return 0;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
