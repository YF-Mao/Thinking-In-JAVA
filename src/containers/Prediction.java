package containers;

import java.util.Random;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class Prediction {
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter";
        } else {
            return "Early Spring";
        }
    }
}
