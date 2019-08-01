package arrays;

import java.util.Arrays;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class AutoboxingArrays {
    public static void main(String[] args) {
        Integer[][] a = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80}
        };
        System.out.println(Arrays.deepToString(a));

        Integer[][] b = new Integer[3][];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer[i + 3];
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(b));

        Integer[][] a1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Double[][][] a2 = {
                {{1.1, 2.2}, {3.3, 4.4}},
                {{5.5, 6.6}, {7.7, 8.8}},
                {{9.9, 1.2}, {2.2, 3.4}}
        };
        String[][] a3 = {
                {"The", "Quick", "Sly", "Fox"},
                {"Jumped", "Over"},
                {"The", "Lazy", "Brown", "Dog", "and", "friend"}
        };
        System.out.println("a1: " + Arrays.deepToString(a1));
        System.out.println("a2: " + Arrays.deepToString(a2));
        System.out.println("a3: " + Arrays.deepToString(a3));
    }
}
