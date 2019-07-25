package typeinfo;

import typeinfo.interfacea.A;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class InterfaceVoilation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}

class B implements A {

    @Override
    public void f() {

    }

    public void g() {

    }
}
