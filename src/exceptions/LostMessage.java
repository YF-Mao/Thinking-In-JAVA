package exceptions;

/**
 * @description: finally中如果有异常，会造成try语句中的异常的缺失
 * @author: YF.Mao
 * @create: 2019/7/19
 **/
public class LostMessage {
    void f() throws VeryImportantExcepiton {
        throw new VeryImportantExcepiton();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage im = new LostMessage();
            try {
                im.f();
            } finally {
                im.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class VeryImportantExcepiton extends Exception {
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}
