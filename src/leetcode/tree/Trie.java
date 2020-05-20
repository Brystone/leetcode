package leetcode.tree;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/20 10:08
 */
public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        //判断整个字符是是否存在，不存在就新建一个子树插入
        for (int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar); //根据字符找到字符对应的结点
        }
     node.setEnd(); //最后一个结点
    }

    //键就是路径
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for (int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd(); //如果所有结点都为空了并且到结束标志了，查询成功； 数中查询结点多了少了都错
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
