package strings;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/22
 **/
public class IntegerMatch {
    /**
     * 正则表达式基础：\\表示要插入一个正则表达式的反斜杠，如\\d表示正数，如果要识别一个普通的反斜杠，则需要\\\\来表示了
     * \W: 非单词字符    \w: 表示一个单词字符
     * X{n,m}: X至少n次，且不超过m次    X*：零个或多个X
     * \S: 非空格字符    \s: 空格字符
     *
     */
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));

        /**
         * 如果有&&，则是取前后的并集，没有则是取交集
         *
         */
        System.out.println("i".matches("[h[hij]]"));
        System.out.println("i".matches("[h&&[hij]]"));
    }
}
