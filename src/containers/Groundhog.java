package containers;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/25
 **/
public class Groundhog {
    protected int number;

    public Groundhog(int n) {
        this.number = n;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}
