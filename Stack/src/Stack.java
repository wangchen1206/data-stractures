/**
 * @Author: cc
 * @Date: 2019/12/10 16:11
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
