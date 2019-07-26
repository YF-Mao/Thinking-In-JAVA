package typeinfo;

import net.mindview.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class NRobot {
    /**
     * 为啥使用动态代理的时候没加Null.class，r instanceof Null就是false
     *
     */
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(Robot.class.getClassLoader()
                , new Class[]{Null.class, Robot.class}, new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        //TODO 7.模拟对象和桩的概念理解
        Robot[] bots = {new SnowRemovalRobot("YF.Mao"), newNullRobot(SnowRemovalRobot.class)
                , newNullRobot(NullRobotProxyHandler.NRobot.class)};
        for (Robot robot : bots) {
            Robot.Test.test(robot);
            System.out.println("===============");
        }
    }
}

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot();

    public NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }

    public class NRobot implements Null, Robot {
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

}
