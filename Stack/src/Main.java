import java.util.Random;

public class Main {

    public static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        //ArrayQueue 和 LoopQueue 性能测试

        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("时间复杂度：O(n^2), ArrayStack, time: " + testStack(arrayStack,opCount) + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("时间复杂度：O(n) , linkedListStack, time: " + testStack(linkedListStack,opCount) + " s");

        //其实这个时间比较复杂，因为LinkedListStack中包含很多的new操作。
    }
}
