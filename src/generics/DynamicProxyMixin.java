package generics;

import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class DynamicProxyMixin {
    //TODO 11.混型的实例 mixin是动态类型，因为存储了方法名所对应的类名。就可以动态调用相应的方法
    //但是需要强制将这些对象先向下转型到恰当的类型
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                new TwoTuple(new BasicImp(), Basic.class),
                new TwoTuple(new TimeStampedImp(), TimeStamped.class),
                new TwoTuple(new SerialNumberedImp(), SerialNumbered.class));
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple<Object, Class<?>>... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = pairs[i].second;
        }
        ClassLoader classLoader = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(classLoader, interfaces, new MixinProxy(pairs));
    }
}
