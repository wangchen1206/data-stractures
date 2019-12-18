import java.util.ArrayList;

public class Main {

    private static double testSet(Set set,String filename){
        long startTime = System.nanoTime();

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(filename,words1)){
            System.out.println("Total words: "+words1.size());

            for (String word:words1)
                set.add(word);
            System.out.println("Total different words: "+set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;

    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, "pride-and-prejudice.txt");
        System.out.println("BSTSet time: "+time1);

        System.out.println();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, "pride-and-prejudice.txt");
        System.out.println("LinkedListSet time: "+time2);

    }
}
