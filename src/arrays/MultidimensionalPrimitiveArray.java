package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        //多维数组的创建和打印
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {1, 2}};
        System.out.println(Arrays.deepToString(a));

        int[][][] b = new int[2][2][4];
        System.out.println(Arrays.deepToString(b));

        //粗糙数组，长度由随机数确定的
        Random random = new Random(47);
        int[][][] c = new int[random.nextInt(7)][][];
        for (int i = 0; i < c.length; i++) {
            c[i] = new int[random.nextInt(5)][];
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = new int[random.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(c));

        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere()},
                {new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere()}
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
