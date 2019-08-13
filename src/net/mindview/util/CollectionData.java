package net.mindview.util;

import java.util.ArrayList;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/2
 **/
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}
