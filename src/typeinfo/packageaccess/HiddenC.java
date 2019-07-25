package typeinfo.packageaccess;

import typeinfo.interfacea.A;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class HiddenC {
    /**
     * 即使你从makeA()返回的是C类型，在包的外部仍旧不能使用A之外任何方法，因为
     * 你不能再包的外部命名C
     *
     */
    public static A makeA() {
        return new C();
    }
}

class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}
