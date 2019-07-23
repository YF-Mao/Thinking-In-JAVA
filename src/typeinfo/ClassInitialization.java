package typeinfo;

import java.util.Random;

/**
 * @description: 初始化加载的时候，实现了尽可能的“惰性”
 * @author: YF.Mao
 * @create: 2019/7/24
 **/
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * Initable.class  不会发生初始化
         * Class.forName() 则会发生初始化
         *
         * 如果不是一个编译期常量，则会对类进行初始化
         * 类在被读取前，会先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）
         *
         */
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);

        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
