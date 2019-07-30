package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS derivedSetter = new DerivedGS();
        derivedSetter.set(derived);
        derivedSetter.set(base);


        Test test = new Test();
        Test1 test1 = new Test1();
        DerivedGS1 derivedGS1 = new DerivedGS1();
        derivedGS1.set(test);
        derivedGS1.set(test1);
    }
}

class GenericSetter1<T extends GenericSetter<T>> {
    void set(T base) {
        System.out.println("自限定 GenericSetter.set(Base)");
    }
}

class Test extends GenericSetter<Test> {

}

class Test1 extends Test {

}

class DerivedGS1 extends GenericSetter1<Test> {
    void set(Test1 derived) {
        System.out.println("DerivedGS.set(Test1)");
    }
}

class GenericSetter<T> {
    void set(T base) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base> {
    void set(Derived derived) {
        System.out.println("DerivedGS.set(Derived)");
    }
}