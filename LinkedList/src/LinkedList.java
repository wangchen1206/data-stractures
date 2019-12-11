/**
 * @Author: cc
 * @Date: 2019/12/11 16:26
 */
public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return this.e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    /**
     * 获取链表元素个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }



    /**
     * 在链表中添加元素
     * （在链表中不是一个常用操作，练习用）
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");


        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            prev = prev.next;
        }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 在链表头添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * 在链表尾部添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(this.size, e);
    }
}
