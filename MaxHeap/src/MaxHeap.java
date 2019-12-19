/**
 * @Author: cc
 * @Date: 2019/12/19 16:28
 */
public class MaxHeap<E extends Comparable> {

    private Array<E> data;

    public MaxHeap(int capasity) {
        this.data = new Array<>(capasity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    /**
     * 返回堆中元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 堆中是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && (data.get(parent(k)).compareTo(data.get(k)) < 0)) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
}
