import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words1)){
            System.out.println("Total words: "+words1.size());

            BSTSet<String> bstSet = new BSTSet<>();
            for (String word:words1)
                bstSet.add(word);
            System.out.println("Total different words: "+bstSet.getSize());
        }
        System.out.println();
        System.out.println("A Table of Two Citiys");
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt",words2)){
            System.out.println("Total words: "+words1.size());

            BSTSet<String> bstSet = new BSTSet<>();
            for (String word:words2)
                bstSet.add(word);
            System.out.println("Total different words: "+bstSet.getSize());
        }

    }
}
