
/**
 * @Author: ck
 * @Date: 2019/12/11 23:19
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
        for (int i = 0; i < index; i++) {
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

    /**
     * 从链表中删除指定index(0->based)位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        //GC回收
        retNode.next = null;
        size --;

        return retNode.e;
    }

    /**
     * 删除链表中的第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表中的最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 获取链表的第index（0-based）个位置的元素e
     * 不是常用操作，为了理解逻辑，练习。
     * @param index
     */
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Update failed. Illegal index");

        Node cur  = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 链表中是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur+"->");
            cur = cur.next;
        }
//        for (Node cur = dummyHead.next;cur != null;cur = cur.next){
//            res.append(cur+"->");
//        }
        res.append("Null");
        return res.toString();
    }
}
