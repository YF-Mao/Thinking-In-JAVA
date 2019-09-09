package annotations;

import net.mindview.atunit.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/30
 **/
public class AtUnitExample1 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    boolean methodOneTest() {
        return "This is methodOne".equals(methodOne());
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }

    @Test
    boolean failureTest() {
        return false;
    }

    public static void main(String[] args) {

    }

}
