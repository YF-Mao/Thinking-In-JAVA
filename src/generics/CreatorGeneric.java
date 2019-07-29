package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}

abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {

}

class Creator extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

