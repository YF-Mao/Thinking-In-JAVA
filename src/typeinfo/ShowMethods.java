package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/25
 **/
public class ShowMethods {
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Test");
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName("typeinfo.ShowMethods");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor ctor : ctors) {
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                    Matcher m = p.matcher(ctor.toString());
                    while (m.find()) {
                        System.out.print(m.group() + " ");
                    }
                    System.out.println();
                    System.out.println(ctor.toString());
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().contains(args[1])) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
