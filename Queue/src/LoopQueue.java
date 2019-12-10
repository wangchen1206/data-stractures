/**
 * @Author: ck
 * @Date: 2019/12/10 22:54
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capasity){
        //因为要浪费一个空间，来维护循环队列 front == tail 队列为空
        this.data = (E[]) new Object[capasity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapasity(){
        return this.data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return this.front == this.tail;
    }

    @Override
    public int getSize(){
        return this.size;
    }
}
