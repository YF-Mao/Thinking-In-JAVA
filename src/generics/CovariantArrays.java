package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class CovariantArrays {
    public static void main(String[] args) {
        //初始化的时候因为是Apple类型，所以在Fruit数组中只能放Apple或Apple的子类型
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        try {
            //能通过编译的原因是Fruit[]的引用，在编译期允许将Fruit及其子类放入数组中
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Fruit {

}

class Apple extends Fruit {

}

class Jonathan extends Apple {

}

class Orange extends Fruit {

}
