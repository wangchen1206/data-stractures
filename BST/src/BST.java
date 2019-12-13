/**
 * @Author: ck
 * @Date: 2019/12/12 21:07
 */
public class BST<E extends Comparable> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 向二分搜索树中添加一个元素。
     *
     * @param e
     */
    public void add(E e) {
        if (this.root == null) {
            this.root = new Node(e);
            this.size++;
        } else {
            add(this.root, e);
        }


    }

    /**
     * 向以node为根节点的二分搜索树中插入元素e，递归算法。
     * 返回插入新节点后二分搜索树的根节点。
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        //递归停止条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            //挂接返回的二分搜索树根节点
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            //挂接返回的二分搜索树根节点
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查看 以node为根的二分搜索树是否包含e,递归算法。
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        //递归终止的条件
        if (node == null)
            return false;

        //没有终止，进行操作。
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) == 0) {
            return true;
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根节点的二分搜索树，递归算法
     * @param node
     */
    private void preOrder(Node node) {
        //递归终止的条件
        if (node == null)
            return;

        //没有终止
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根节点的二分搜索树，递归算法。
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以node为根节点的二分搜索树，递归算法。
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return ;
        }

        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
