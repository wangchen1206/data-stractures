
/**
 * LoopQueue 声明size
 *
 * @Author: ck
 * @Date: 2019/12/10 22:54
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capasity) {
        //因为要浪费一个空间，来维护循环队列 front == tail 队列为空
        this.data = (E[]) new Object[capasity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapasity() {
        return this.data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void enqueue(E e) {
        //先判断队列是否满
        if ((tail + 1) % data.length == front)
            resize((data.length - 1) * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapasity() / 4 && getCapasity() / 2 != 0)
            resize(getCapasity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capasity = %s\n", size, getCapasity()));
        res.append("front [");

        //第一种遍历方式
//        for (int i = 0; i < this.size; i++) {
//            res.append(this.data[(i+front)%data.length]);
//            if (i != this.size - 1)
//                res.append(", ");
//        }
        //第二种遍历的方式
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }

        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapasity) {
        E[] newData = (E[]) new Object[newCapasity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

//        for (int i = front; i != tail ; i = (i+1)%data.length) {
//            newData[i] = data[i];
//        }

        data = newData;
        front = 0;
        tail = size;
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
