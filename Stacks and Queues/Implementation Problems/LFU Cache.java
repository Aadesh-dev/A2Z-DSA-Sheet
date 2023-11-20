class LFUCache {

    Map<Integer, Node> nodeMap;
    Map<Integer, DLL> freqMap;
    int capacity, freq;

    public LFUCache(int capacity) {
        freqMap = new HashMap<>();
        nodeMap = new HashMap<>();
        this.capacity = capacity;
    }

    public void updateFreqMap(Node node) {
        int nodeFreq = node.freq;
        DLL curList = freqMap.get(nodeFreq);
        curList.remove(node);
        if(nodeFreq == freq && curList.size == 0) freq++;
        DLL nextList = freqMap.getOrDefault(nodeFreq + 1, new DLL());
        nextList.insert(node);
        node.freq++;
        freqMap.put(node.freq, nextList);
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            updateFreqMap(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateFreqMap(node);
        } else {
            if(nodeMap.size() == capacity) {
                DLL minFreqList = freqMap.get(freq);
                nodeMap.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
            }

            Node node = new Node(key, value);
            freq = 1;
            DLL newList = freqMap.getOrDefault(1, new DLL());
            newList.insert(node);
            freqMap.put(1, newList);
            nodeMap.put(key, node);
        }
    }

    class Node {
        public int key, freq;
        public int value;
        public Node next;
        public Node prev;

        Node() {

        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    };

    class DLL {
        Node head, tail;
        int size;

        public DLL() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void insert(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }
}
//Time: O(1), Space: O(n)

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */