package leetcode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 题目：LRU 缓存机制 插入、删除、查询快、有序
 * 思路：哈希表 + 链表
 *
 * @author ：stone
 * @date ：Created in 2020/3/26 15:45
 */
public class LRUCache{
    //双向链表里的结点
    class Node {
        public int key, val; //键值
        public Node next, prev; //前后指针
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    //双向链表 属性有头尾虚结点、链表元素个数
    class DoubleList {
        private Node head, tail; // 头尾虚节点
        private int size; // 链表元素数

        //初始化
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.prev == head) //只剩两个虚结点，直接返回空
                return null;
            Node last = tail.prev; //保存
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() { return size; }
    }

    // key -> Node(key, val)
    private HashMap<Integer, Node> map;  //map用来查询 key 值是Node
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache; //Node用双向链表来存储
    // 最大容量
    private int cap; //最大的容量

    //构造器
    public LRUCache(int capacity) {
        this.cap = capacity;


        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前

        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
