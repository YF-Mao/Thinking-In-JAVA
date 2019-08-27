package containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/8/24
 **/
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        a.addAll(Countries.names(25));
        a.addAll(3, Countries.names(3));

        b = a.contains("1");
        b = a.containsAll(Countries.names(25));

        s = a.get(1);
        i = a.indexOf("1");
        b = a.isEmpty();

        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3);


        a.retainAll(Countries.names(25));
        a.removeAll(Countries.names(25));

        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        it.next();
        //it.nextIndex();
        it.remove();
        //it.nextIndex();
        it.next();
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        System.out.println("testVisual started");
        System.out.println(a);
        List<String> b = Countries.names(25);
        System.out.println("b=" + b);
        a.addAll(b);
        a.addAll(b);
        System.out.println(a);
        ListIterator<String> x = a.listIterator(a.size() / 2);
        x.add("one");
        System.out.println(a);
        System.out.println(x.next());
        x.remove();
        System.out.println(x.next());
        x.set("47");
        System.out.println(a);
        x = a.listIterator(a.size());
        while (x.hasPrevious()) {
            System.out.print(x.previous() + " ");
        }
        System.out.println();
        System.out.println("testVisual finished");
    }

    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(Countries.names(25));
        System.out.println(ll);
        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);
        System.out.println(ll.getFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());

        System.out.println(ll.removeLast());
        System.out.println(ll);
    }

    public static void main(String[] args) {
        basicTest(new LinkedList<>(Countries.names(25)));
        basicTest(new ArrayList<>(Countries.names(25)));
        iterMotion(new LinkedList<>(Countries.names(25)));
        iterMotion(new ArrayList<>(Countries.names(25)));
        iterManipulation(new LinkedList<>(Countries.names(25)));
        iterManipulation(new ArrayList<>(Countries.names(25)));
        testVisual(new LinkedList<>(Countries.names(25)));
        testLinkedList();
    }
}
