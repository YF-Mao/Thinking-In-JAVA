package generics.coffee;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/27
 **/
public class Coffee {
    /**
     * 重新明确下概念
     * static 该类的所有对象所共有
     * final 这个引用无法更改，不过可以更改引用的内容
     *
     */
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
