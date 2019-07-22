package innerclass;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/5
 **/
class Egg {
    private Yolk y;
    protected class Yolk{
        public Yolk() {
            System.out.println("Egg.Yolk");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }

    static class Inner{

    }
}
