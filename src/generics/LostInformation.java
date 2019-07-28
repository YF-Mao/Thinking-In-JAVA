package generics;

import java.util.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class LostInformation {
    public static void main(String[] args) {
        //TODO 10.由于java是通过擦除来实现泛型的，所以在泛型代码内部，无法获得任何有关泛型参数类型的信息
        //在使用泛型时，任何具体的类型信息都被擦除了
        // 不能用于显示地引用运行时类型的操作之中，例如instanceof操作和new表达式，而且只是一个Object
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>(Frob.class);
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));

        System.out.println(quark.type.getSimpleName());
    }
}

class Frob {
}

class Fnorkle {

}

class Quark<Q> {
    public Class<?> type;

    public Quark() {

    }

    public Quark(Class<?> type) {
        this.type = type;
    }
}

class Particle<POSITION, MEOMENTUM> {

}