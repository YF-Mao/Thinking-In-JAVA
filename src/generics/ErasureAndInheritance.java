package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object obj = derived2.get();
        derived2.set(obj);
    }
}

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        arg = element;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

class Derived2 extends GenericBase {

}

