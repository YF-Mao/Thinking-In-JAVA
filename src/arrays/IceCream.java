package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class IceCream {
    private static Random random = new Random(47);
    static final String[] FLAVORS = {"This", "represents", "the", "entry point", "in", "a coyote-based", "servlet", "container."};

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = random.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
