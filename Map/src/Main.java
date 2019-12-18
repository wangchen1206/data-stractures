import java.util.ArrayList;

public class Main {

    public static double testMap(Map<String,Integer> map,String filename){
        long startTime = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word))
                    map.set(word,map.get(word)+1);
                else
                    map.add(word,1);
            }
            System.out.println("Total different words: "+map.getSize());
            System.out.println("Frequency of pride: "+map.get("pride"));
            System.out.println("Frequency of prejudice: "+map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap,filename);
        System.out.println("BST Map : "+time1+" s");

        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap,filename);
        System.out.println("BST Map : "+time2+" s");

    }
}
