package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/2
 **/
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();

    }
}
