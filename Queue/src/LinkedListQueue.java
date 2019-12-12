/**
 * @Author: cc
 * @Date: 2019/12/12 10:32
 */
public class LinkedListQueue<E> implements Queue<E> {

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

    private Node head,tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从尾部添加元素 O(1)
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }


    /**
     * 从队列头部dequeue
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        Node ret = head;
        head = head.next;
        ret.next = null;
        if (head == null)
            tail = null;
        size--;
        return ret.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");

        Node cur = head;
        while (cur != null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
