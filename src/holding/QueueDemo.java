package holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @description: 普通队列，先进先出的容器
 * @author: YF.Mao
 * @create: 2019/7/9
 **/
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10;i++) {
            Integer integer = random.nextInt(20);
            System.out.print(integer + "  ");
            queue.offer(integer);
        }
        System.out.println();
        printQueue(queue);
        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQueue(qc);
    }

    public static void printQueue(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
