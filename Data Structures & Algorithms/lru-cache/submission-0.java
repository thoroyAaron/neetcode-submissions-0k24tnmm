class LRUCache {

    // 双向链表节点
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head; // 哨兵头节点，head.next 是最近使用的
    private final Node tail; // 哨兵尾节点，tail.prev 是最久未使用的

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 命中后，移动到头部表示最近使用
        remove(node);
        addToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            // key 已存在，更新值并移动到头部
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            if (cache.size() >= capacity) {
                // 容量已满，删除尾部（最久未使用）节点
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    // 从链表中移除某个节点
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点插入到链表头部（紧跟在 head 哨兵之后）
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}