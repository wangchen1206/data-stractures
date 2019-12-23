import java.util.TreeMap;

/**
 * @Author: ck
 * @Date: 2019/12/23 20:43
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 获得在Trie中存储的单词数量
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 向Trie中添加一个单词
     * @param word
     */
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        //是否有这个单词
        if (!cur.isWord){
            cur.isWord = true;
            this.size++;
        }
    }

    /**
     * Trie中是否包含某个单词
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查看是否在Trie中有以prefix为前缀的单词。
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        //遍历完了prefix,说明在Trie中包含以prefix为前缀的单词
        return true;
    }

}
