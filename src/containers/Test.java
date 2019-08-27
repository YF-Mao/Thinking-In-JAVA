package containers;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/20
 **/
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam tp);
}


