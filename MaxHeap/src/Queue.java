/**
 * @Author: ck
 * @Date: 2019/12/10 20:34
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
