/**
 * 实现第二版并查集
 * 用树实现。孩子节点指向父亲节点
 *
 * @Author: ck
 * @Date: 2019/12/29 21:53
 */
public class UnionFind3 implements UF {

    //存放的是每个元素所指向的父亲节点
    private int[] parent;
    //存放的是每个根节点所在树的大小
    private int[] sz;

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.sz = new int[size];

        //这个操作是每个节点指向字节，初始化size个树根。
        for (int i = 0; i < this.parent.length; i++) {
            this.parent[i] = i;
            this.sz[i] = 1;
        }

    }

    @Override
    public int getSize() {
        return this.parent.length;
    }

    /**
     * 判读两个元素是否在同一个集合中。或者说是否在同一个树中。
     * 时间复杂度 O(h),h为两个元素在树中所在的高度之和。
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将两个元素合并在同一个树中。也就是将某一个元素所在树的根指向另一个元素所在树的根。将两个元素所在的树根连接
     * 时间复杂度 O(h),h为两个元素在树中所在的高度之和。
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;

        //判断合并方向，优化
        //将元素少的树合并到元素多的树中。这样会减少树的高度。扩大树这种结构查询的优势。
        if (this.sz[pRoot] < this.sz[qRoot]){
            this.parent[pRoot] = qRoot;
            this.sz[qRoot] += this.sz[pRoot];
        }else {
            this.parent[qRoot] = pRoot;
            this.sz[pRoot] += this.sz[qRoot];
        }

    }

    /**
     * 查找元素p所在树的根节点
     * 时间复杂度是O(h),h为元素p所在树中元素p的高度
     *
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p >= this.parent.length)
            throw new IllegalArgumentException(" p is out of bound");
        //直到元素指向的父亲节点是该元素本身，也就找到了树的根。
        while (p != this.parent[p])
            p = this.parent[p];
        return p;
    }


}
