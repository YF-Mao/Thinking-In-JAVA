package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/31
 **/
public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Faulure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch (Faulure1 e) {
            System.out.println(e);
        }

        ProcessRunner<Integer, Faulure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }

        try {
            System.out.println(runner2.processAll());
        } catch (Faulure2 e) {
            System.out.println(e);
        }
    }
}

interface Processor<T, E extends Exception> {
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
    //抛出了具有类型E的异常，以此达到可以编写随检查型异常的类型的而发生变化的泛型代码
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Faulure1 extends Exception {

}

class Processor1 implements Processor<String, Faulure1> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Faulure1 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if (count < 0) {
            throw new Faulure1();
        }
    }
}

class Faulure2 extends Exception {

}

class Processor2 implements Processor<Integer, Faulure2> {
    static int count = 3;

    @Override
    public void process(List<Integer> resultCollector) throws Faulure2 {
        if (count-- > 1) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if (count < 0) {
            throw new Faulure2();
        }
    }
}