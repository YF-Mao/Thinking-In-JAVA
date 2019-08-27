package annotations;

import net.mindview.atunit.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/27
 **/
public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
}
