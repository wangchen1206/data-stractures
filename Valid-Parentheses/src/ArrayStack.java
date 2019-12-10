package src;

/**
 * @Author: cc
 * @Date: 2019/12/10 16:15
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capasity) {
        this.array = new Array<>(capasity);
    }

    public ArrayStack() {
        this.array = new Array<>();
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
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < this.array.getSize(); i++) {
            res.append(array.get(i));
            if (i != this.array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
