package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/17
 **/
public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
        } finally {
            sw.off();
        }
    }
}
