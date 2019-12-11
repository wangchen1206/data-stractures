import java.util.Random;

public class Main {

    public static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        //ArrayQueue 和 LoopQueue 性能测试

	    int opCount = 100000;
	    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("时间复杂度：O(n^2), ArrayQueue, time: " + testQueue(arrayQueue,opCount) + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("时间复杂度：O(n) , LoopQueue, time: " + testQueue(loopQueue,opCount) + " s");
    }
}
