package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/19
 **/
public class StormyInning extends Inning implements Storm {
    /**
     * 构造器可以抛出任何异常，但是派生类构造器必须包含基类构造器的异常说明
     * 总结一句就是，派生类所抛出的异常范围要小于等于基类所抛出的异常范围
     *
     */
    public StormyInning() throws RainedOut, BaseballException {

    }

    public StormyInning(String s) throws Foul, BaseballException {

    }

    @Override
    public void atBat() throws PopFoul {

    }

    @Override
    public void event() {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        /**
         * 向上转型成基类型的时候，编译器会要求你捕获基类的异常
         * 如实例所加的 Strike异常
         *
         */
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike strike) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }

    @Override
    public void rainHard() throws RainedOut {

    }
}

class BaseballException extends Exception {

}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

abstract class Inning {
    public Inning() throws BaseballException {
        throw new BaseballException();
    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {

    }
}

class StormException extends Exception {

}

class RainedOut extends StormException {

}

class PopFoul extends Foul {

}

interface Storm {
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}