/**
 * @Author: ck
 * @Date: 2019/12/10 20:39
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capasity) {
        this.array = new Array(capasity);
    }

    public ArrayQueue() {
        this.array = new Array();
    }


    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int getCapasity() {
        return this.array.getCapasity();
    }

    @Override
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < this.array.getSize(); i++) {
            res.append(this.array.get(i));
            if (i != this.array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();

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
