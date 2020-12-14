import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the String which contains only {,},[,],(,)");
        Scanner scanner = new Scanner(System.in);
        String bracketsString = scanner.next();
        if (checkBrackets(bracketsString)) {
            System.out.println("Brackets String is Symmetric");
        } else {
            System.out.println("Brackets String is Not Symmetric");
        }
        System.out.println();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(-6);
        priorityQueue.add(14);
        priorityQueue.add(-9);
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("Printing Priority Queue: " + priorityQueue);
        System.out.println("Remove: " + priorityQueue.remove());
        System.out.println("Printing Priority Queue after Remove: " + priorityQueue);
        System.out.println();
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>(new CompareByStringLength());
        priorityQueue1.add("Armen");
        priorityQueue1.add("Susanna");
        priorityQueue1.add("Anna");
        priorityQueue1.add("Karine");
        while (!priorityQueue1.isEmpty()) {
            System.out.println(priorityQueue1.remove());
        }
    }

    public static boolean checkBrackets(String bracketsString) {
        Stack<Character> bracketsStack = new Stack<>();
        for (int i = 0; i < bracketsString.length(); i++) {
            if (!bracketsStack.isEmpty()) {
                if ((bracketsString.charAt(i) == ')' && bracketsStack.peek() == '(')
                        || (bracketsString.charAt(i) == '}' && bracketsStack.peek() == '{')
                        || (bracketsString.charAt(i) == ']' && bracketsStack.peek() == '[')) {
                    bracketsStack.pop();
                } else {
                    bracketsStack.push(bracketsString.charAt(i));
                }
            } else {
                bracketsStack.push(bracketsString.charAt(i));
            }
        }
        return bracketsStack.isEmpty();
    }
}