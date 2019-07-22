package innerclass;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/5
 **/
public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            {
                System.out.println("test!");
            }
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }

    public class Wrapping {
        private int i;

        public Wrapping(int x) {
            i = x;
        }

        public int value() {
            return i;
        }
    }

}
