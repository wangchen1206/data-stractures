/**
 * 最大堆
 * 是一个完全二叉树
 * 每一个节点的值不大于其父节点的值，堆顶是最大值
 *
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
     * 构造函数 ，将一个数组heapify整理成堆
     * 时间复杂度是 O(n)
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
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
        return (index - 1) / 2;
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
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中最大的元素，堆无任何变化
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();

        //先交换堆顶和最后一个元素的位置
        data.swap(0, data.getSize() - 1);
        //数组去除最后一个元素，也就是最大的元素
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            //如果没有右孩子，则data[k] 与 data[leftChild(k)]相比，看是否交换位置
            int j = leftChild(k);
            //如果有右孩子，则左孩子与右孩子相比谁大。
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            //data[j] 是leftChild 和 rightChild 中最大值

            //data[k] 与data[j]相比，看是否交换位置
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            //交换位置
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中最大元素，并替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        //先替换堆顶的元素
        data.set(0, e);
        //再进行siftDown
        siftDown(0);
        return ret;
    }

}
