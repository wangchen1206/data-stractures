import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     *
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
     * 前序遍历的非递归算法。
     * 深度优先遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根节点的二分搜索树，递归算法。
     *
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
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根节点的二分搜索树，递归算法。
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     * 广度优先遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

    }

    /**
     * 找出最小的元素
     * @return
     */
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    /**
     * 递归，返回以node为根的二分搜索树的最小值的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * 找出最大的元素
     * @return
     */
    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }

    /**
     * 递归，返回以node为根的二分搜索树最大值的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中最小的节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;

    }

    /**
     * 从二分搜索树中删除最大值所在的节点，返回最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中最大的节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;

    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后的新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if(node == null)
            return null;
        if (e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else{
            //删除只有右子树的节点
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //删除只有左子树的节点
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //删除左右子树都有的节点
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left=node.right=null;
            return successor;

        }

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
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
