class Node{
    int key,value,count;
    Node prev;
    Node next;

    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.count=1;
    }
}

class DoubleLinkedList{
    Node head;
    Node tail;
    int size;

    public DoubleLinkedList(){
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size=0;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void insertAfterHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }
}

class LFUCache {
private HashMap<Integer,Node> keyNode;
    private HashMap<Integer, DoubleLinkedList> freqListMap;
    int maxSize,minFreq,curSize;

    public LFUCache(int capacity) {
        maxSize=capacity;
        minFreq=0;
        curSize=0;
        keyNode=new HashMap<Integer,Node>();
        freqListMap=new HashMap<Integer, DoubleLinkedList>();
    }

    public void updateFreqList(Node node){
        keyNode.remove(node.key);
        freqListMap.get(node.count).deleteNode(node);
        if(node.count==minFreq && freqListMap.get(node.count).size==0) minFreq++;
        DoubleLinkedList nextHigherFreqList=new DoubleLinkedList();
        if(freqListMap.containsKey(node.count+1)) nextHigherFreqList=freqListMap.get(node.count+1);
        node.count++;
        nextHigherFreqList.insertAfterHead(node);
        freqListMap.put(node.count,nextHigherFreqList);
        keyNode.put(node.key,node);
    }

    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        updateFreqList(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(maxSize==0) return;
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqList(node);
        }
        else{
            if(curSize==maxSize){
                DoubleLinkedList list=freqListMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                freqListMap.get(minFreq).deleteNode(list.tail.prev);
                curSize--;
            }
            curSize++;
            minFreq=1;
            DoubleLinkedList listFreq=freqListMap.getOrDefault(minFreq,new DoubleLinkedList());
            Node newNode=new Node(key,value);
            listFreq.insertAfterHead(newNode);
            keyNode.put(key,newNode);
            freqListMap.put(minFreq,listFreq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */