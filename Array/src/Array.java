/**
 * @Author: ck
 * @Date: 2019/12/9 20:41
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 传入数组的容量
     *
     * @param capasity
     */
    public Array(int capasity) {
        this.data = new int[capasity];
        this.size = 0;
    }

    /**
     * 默认数组的容量为10
     */
    public Array() {
        this(10);
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
    public void addLast(int e) {
        add(this.size, e);
    }

    /**
     * 在数组的第一个位置添加元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在指定位置添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == this.data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Required index >= 0 and index <= size");

        for (int i = size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] = e;
        this.size++;
    }

    /**
     * 查询
     *
     * @param index
     * @return
     */
    int get(int index) {
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
    void set(int index, int e) {
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
    public boolean contains(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e)
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
    public int find(int e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e)
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
    public int remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        int ret = this.data[index];
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.size--;
        return ret;
    }

    /**
     * 删除数组中第一个元素
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return
     */
    public int removeLast(){
        return remove(this.size-1);
    }

    /**
     * 删除某一个元素
     * （只会删除第一个与元素e相等的元素）
     * @param e
     */
    public void removeElement(int e){
        int index = find(e);
        if (index != -1)
            remove(index);
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
