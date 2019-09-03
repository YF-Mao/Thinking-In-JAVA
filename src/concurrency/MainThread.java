package concurrency;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/2
 **/
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
