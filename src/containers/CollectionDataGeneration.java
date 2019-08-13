package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/2
 **/
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<>(CollectionData.list(new RandomGenerator.String(9), 10)));

        System.out.println(new HashSet<>(new CollectionData<>(new RandomGenerator.Integer(), 10)));
    }
}
