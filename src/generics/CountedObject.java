package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/28
 **/
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}
