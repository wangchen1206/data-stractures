/**
 * 第一版的实现。数组实现。
 *
 * @Author: ck
 * @Date: 2019/12/29 21:25
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];
        //初始化操作，将每个元素的集合id设置为唯一的。
        for (int i = 0; i < id.length; i++) {
            this.id[i] = i;
        }

    }

    @Override
    public int getSize() {
        return this.id.length;
    }

    /**
     * 查看元素p和q是否属于同一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和q所属的集合。
     * 时间复杂度 O(n)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return ;
        for (int i = 0; i < this.id.length; i++) {
            if (this.id[i] == pID)
                this.id[i] = qID;
        }
    }

    /**
     * 查找元素p对应的集合编号
     * 时间复杂度，O(1)
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p >= this.id.length)
            throw new IllegalArgumentException(" p is out of bound");
        return this.id[p];
    }

}
