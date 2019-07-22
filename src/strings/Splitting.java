package strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/22
 **/
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n");
        split("n\\W+");
    }
}
