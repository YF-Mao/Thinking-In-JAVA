package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class Fill {
    public static <T> void fill(Collection<T> collection, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                collection.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Contract {
    private static long count = 0;
    private final long id = count++;

    @Override
    public String toString() {
        return getClass().getName() + " " + id;
    }
}

class TitleTransfer extends Contract {

}

class FillTest {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts, Contract.class, 3);
        Fill.fill(contracts, TitleTransfer.class, 2);
        for (Contract c : contracts) {
            System.out.println(c);
        }

        SimpleQueue<Contract> contractSimpleQueue = new SimpleQueue<>();
        //won't work
        //因为 SimpleQueue 没有实现 Collection 类
        //而且java实现泛型 没有通过潜在类型机制来实现的
        //Fill.fill(contractSimpleQueue, Contract.class, 3);
    }
}
