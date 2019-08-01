package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/1
 **/
public class ContainerComparison {
    /**
     * 数组是一种效率最高的存储和随机访问对象引用序列的方式，是一个简单的线性序列
     * 数组对象的大小被固定，并且在其生命周期不可改变
     *
     */
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }

        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliumSphere());
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        integerList.add(97);
        System.out.println(integerList);
        System.out.println(integerList.get(4));
    }
}

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}
