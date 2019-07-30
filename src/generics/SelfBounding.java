package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class SelfBounding {
}

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {

}

class B extends SelfBounded<A> {
}

class D {

}

//error
//因为D类不是 SelfBounded 这个类的超类
//如果要使用，就要保证这个类所用的类型参数将与使用这个参数的类具有相同的基类型
//还可以将自限定用于泛型方法
//class E extends SelfBounded<D> {
//}

class F extends SelfBounded {

}

//error
//class G extends SelfBounded<F> {
//}
