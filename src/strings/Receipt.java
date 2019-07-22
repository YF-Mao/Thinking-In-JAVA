package strings;

import java.util.Formatter;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/22
 **/
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    /**
     * 抽象语法格式： %[argument_index$][flags][width][.precision]conversion
     * width:控制一个域的最小尺寸，默认是右对齐，可以通过-来改变对齐方向
     * precision:不同类型不同用法
     *      String:输出字符的最大数量
     *      浮点型:小数部分要显示出来的位数（默认是6位）
     *      整数:触发异常
     *
     */
    public void printTitle() {
        //TODO 6.fomatter格式修饰符
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
