package generics;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/28
 **/
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
