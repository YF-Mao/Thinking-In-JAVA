package exceptions;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/15
 **/
public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        //TODO 4.这个程序得到的启发就是使循环在放弃以前尝试一定的次数，使得程序更加健壮
        while (true) {
            try {
                if (count++ < 2) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
                break;
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 3) {
                    break;
                }
            }
        }
    }
}

class ThreeException extends Exception {

}
