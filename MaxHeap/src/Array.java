/**
 * @Author: ck
 * @Date: 2019/12/9 20:41
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 传入数组的容量
     *
     * @param capasity
     */
    public Array(int capasity) {
        this.data = (E[]) new Object[capasity];
        this.size = 0;
    }

    /**
     * 默认数组的容量为10
     */
    public Array() {
        this(10);
    }

    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获取数组中元素的个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapasity() {
        return this.data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 在数组的末尾添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(this.size, e);
    }

    /**
     * 在数组的第一个位置添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定位置添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Required index >= 0 and index <= size");

        /**
         * 如果数组满了，进行两倍的size扩容
         */
        if (size == this.data.length)
            resize(2 * this.data.length);
        for (int i = size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] = e;
        this.size++;
    }

    /**
     * 私有的扩容
     *
     * @param newCapasity
     */
    private void resize(int newCapasity) {
        E[] newData = (E[]) new Object[newCapasity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    /**
     * 查询
     *
     * @param index
     * @return
     */
    E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return this.data[index];
    }

    /**
     * 修改
     *
     * @param index
     * @param e
     */
    void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        this.data[index] = e;
    }

    /**
     * 是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查看数组中元素e的索引，如果不存在元素e,返回-1
     * 只会找到第一个，可以返回所有与元素e相等的index[]
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，并返回删除的元素。
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        E ret = this.data[index];
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.size--;
        this.data[size] = null;// loitering objects  != memory leak  游荡的对象，不是内存溢出

        //解决复杂度震荡。当size是capasity的1/4时，进行缩减，并且capasity != 0
        if (this.size == this.data.length / 4 && this.data.length / 2 != 0)
            resize(this.data.length / 2);
        return ret;
    }

    /**
     * 删除数组中第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(this.size - 1);
    }

    /**
     * 删除某一个元素
     * （只会删除第一个与元素e相等的元素）
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * 交换两个位置的元素
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal!");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capasity = %d\n", this.size, this.data.length));
        res.append("[");
        for (int i = 0; i < this.size; i++) {
            res.append(this.data[i]);
            if (i != this.size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}
