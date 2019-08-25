package containers;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class Groundhog2 extends Groundhog {
    public Groundhog2(int n) {
        super(n);
    }

    @Override
    public int hashCode() {
        return number;
    }

    /**
     * 正确的equals必须满足下列5个条件
     * 1.自反性
     * 2.对称性
     * 3.传递性
     * 4.一致性
     * 5.对于任何不适null的x，x.equals(null) 一定返回false
     *
     */
    @Override
    public boolean equals(Object obj) {
        //instanceof 已经检查了obj是否为null
        return obj instanceof Groundhog2 && (number == ((Groundhog2) obj).number);
    }
}
