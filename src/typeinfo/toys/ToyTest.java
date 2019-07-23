package typeinfo.toys;

import static typeinfo.toys.ToyTest.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/24
 **/
public class ToyTest {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            /**
             * 使用newInstance()来创建类，必须带有默认的构造器
             *
             */
            obj = up.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());

        System.out.println("---------------------");
        printInfo(Integer.class);
        printInfo(int.class);
        printInfo(Integer.TYPE);
    }

    public static void printInfo(Class c) {
        System.out.println("Class name: " + c.getCanonicalName() + " is interface? [" + c.isInterface() + "]");
        System.out.println("Simple name: " + c.getSimpleName());
    }
}

interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

class Toy {
    Toy() {

    }

    Toy(int i) {

    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}


