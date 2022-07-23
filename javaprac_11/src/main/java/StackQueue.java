import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);
        integerStack.push(3);
        integerStack.push(7);
        integerStack.push(8);
        integerStack.push(3);

        System.out.println(integerStack);
        System.out.println(integerStack.peek()); //확인만
        System.out.println("size: "+ integerStack.size());
        System.out.println(integerStack.pop()); //꺼내기
        System.out.println("size: "+ integerStack.size());

        System.out.println(integerStack.contains(1));
        System.out.println(integerStack.empty());
        System.out.println(integerStack.isEmpty());

        System.out.println("========Queue==========");

        Queue<Integer> integerQueue = new LinkedList<>();

        integerQueue.add(1);
        integerQueue.add(3);
        integerQueue.add(6);
        System.out.println(integerQueue);
        System.out.println(integerQueue.poll());// 빼내면서 리턴
        System.out.println(integerQueue);
        System.out.println(integerQueue.peek());
        System.out.println(integerQueue);

        System.out.println("=======ArrayDeque===========");

        ArrayDeque <Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);

        System.out.println(arrayDeque);

        arrayDeque.addLast(0);
        System.out.println(arrayDeque);

        arrayDeque.offerFirst(10);
        System.out.println(arrayDeque);
        arrayDeque.offerLast(-1);
        System.out.println(arrayDeque);

        arrayDeque.push(22);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque);














    }
}
