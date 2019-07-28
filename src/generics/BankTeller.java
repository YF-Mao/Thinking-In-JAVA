package generics;

import net.mindview.util.Generator;

import java.util.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/29
 **/
public class BankTeller {
    public static void serve(Teller t, Customer customer) {
        System.out.println(t + " serves " + customer);
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);
        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }
}

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {

    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    public static Generator<Customer> generator() {
        //lambda表达式
        return () -> new Customer();

        //return new Generator<Customer>() {
        //    @Override
        //    public Customer next() {
        //        return new Customer();
        //    }
        //};
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {

    }

    @Override
    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator = () -> new Teller();
}
