package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}

class Base {

}

class Derived extends Base {
}

interface OrdinaryGetter {
    Base get();
}

//导出类的方法能返回比它覆盖的类方法更具体的类型
interface DerivedGetter extends OrdinaryGetter {
    Derived get();
}
