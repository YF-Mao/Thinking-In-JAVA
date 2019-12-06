package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        UUID u = UUID.randomUUID();
        System.out.println(u.toString());
        RealObject real = new RealObject();
        consumer(real);
        /**
         * 使用newProxyInstance()的时候，必须为该代理实现的接口列表的Class
         * 如new Class[]{Interface.class}
         *
         * invoke 中的
         *
         */
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandle(real));
        consumer(proxy);
    }
}

class DynamicProxyHandle implements InvocationHandler {
    private Object proxied;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        return method.invoke(proxied, args);
    }

    public DynamicProxyHandle(Object proxied) {
        this.proxied = proxied;
    }
}
