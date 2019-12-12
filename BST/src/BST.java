/**
 * @Author: ck
 * @Date: 2019/12/12 21:07
 */
public class BST<E extends Comparable> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
