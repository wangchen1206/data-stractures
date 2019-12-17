/**
 * @Author: cc
 * @Date: 2019/12/17 17:34
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
