class Node {
     public int key;
     public int value;
     public Node next;
     public Node prev;

     Node()
     {
         this.key = 0;
         this.value = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int key, int value)
     {
         this.key = key;
         this.value = value;
         this.next = null;
         this.prev = null;
     }

     Node(int key, int value, Node next, Node prev)
     {
         this.key = key;
         this.value = value;
         this.next = next;
         this.prev = prev;
     }
 };


class LRUCache {

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
//Time: O(n) amortized, Space: O(n)

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */