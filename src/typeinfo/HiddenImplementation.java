package typeinfo;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //if (a instanceof C) {
        //    C c = (C) a;
        //    c.g();
        //}
        //can't do this. 因为C这个类在包外不可见
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
