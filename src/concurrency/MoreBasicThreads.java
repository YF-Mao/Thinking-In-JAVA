package concurrency;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/2
 **/
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
