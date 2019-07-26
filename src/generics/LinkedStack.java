package generics;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/7/26
 **/
public class LinkedStack<T> {
    //TODO 8.主要学习构造这个泛型堆栈类背后的思想
    //堆栈就是先进后出，以及判空的标准
    //数据模型就是一个value和指向下一个值的指针，通过构造一个空对象来表示堆栈底。
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
