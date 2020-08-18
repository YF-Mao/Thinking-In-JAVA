package classtest;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2020/3/24
 **/
public class ClassForName {
    static {
        System.out.println("执行静态代码块");
    }

    private static String staticFiled = staticMethod();

    public static String staticMethod() {
        System.out.println("执行静态方法");
        return "给静态字段赋值";
    }

    public String publicMethod(){
        System.out.println(staticFiled);
        return "公有方法";
    }
}
