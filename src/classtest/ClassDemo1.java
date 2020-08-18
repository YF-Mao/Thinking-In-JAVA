package classtest;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2020/3/24
 **/
public class ClassDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassDemo1.class.getClassLoader());
        System.out.println("===========");
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println("===========");
        Class<?> c = Class.forName("classtest.ClassForName");
        Class<?> c2 = ClassLoader.getSystemClassLoader().loadClass("classtest.ClassForName");
        System.out.println("==============");
        System.out.println(((ClassForName)c.newInstance()).publicMethod());
        System.out.println(((ClassForName)c2.newInstance()).publicMethod());
    }
}
