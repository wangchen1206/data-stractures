import java.util.ArrayList;

/**
 * @Author: cc
 * @Date: 2019/12/18 15:02
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words1)){
            System.out.println("Total words: "+words1.size());

            LinkedListSet<String> bstSet = new LinkedListSet<>();
            for (String word:words1)
                bstSet.add(word);
            System.out.println("Total different words: "+bstSet.getSize());
        }
        System.out.println();
        System.out.println("A Table of Two Citiys");
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt",words2)){
            System.out.println("Total words: "+words1.size());

            LinkedListSet<String> bstSet = new LinkedListSet<>();
            for (String word:words2)
                bstSet.add(word);
            System.out.println("Total different words: "+bstSet.getSize());
        }

    }
}
