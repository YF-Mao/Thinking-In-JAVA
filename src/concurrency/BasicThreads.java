package concurrency;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/2
 **/
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
