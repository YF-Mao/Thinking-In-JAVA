package innerclass;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/5
 **/
public class Parcel9 {
    private String test = "ss";
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                //return this.label;
                return addTest();
            }

            private String addTest() {
                return this.label + Parcel9.this.test;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("测试");
        System.out.println(d.readLabel());
    }
}
