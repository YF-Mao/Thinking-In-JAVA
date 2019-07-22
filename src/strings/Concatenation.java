package strings;

/**
 * @description: 可以用javap -c [类名] 来进行反编译.class文件
 * @author: YF.Mao
 * @create: 2019/7/22
 **/
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
