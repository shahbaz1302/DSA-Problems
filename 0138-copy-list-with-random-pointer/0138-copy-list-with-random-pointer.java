/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        insertInBetween(head);
        connectRandomPointers(head);
        return getCopyList(head);
    }

    public void insertInBetween(Node head){
        Node temp=head;
        while(temp!=null){
            Node copyNode=new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
    }

    public void connectRandomPointers(Node head) {
        Node temp=head;
        while(temp!=null){
            Node copyNode=temp.next;
            if(temp.random!=null) copyNode.random=temp.random.next;
            else copyNode.random=null;
            temp=temp.next.next;
        }
    }

    public Node getCopyList(Node head) {
        Node temp=head;
        Node dummyNode=new Node(-1);
        Node curr=dummyNode;
        while(temp!=null){
            curr.next=temp.next;
            temp.next=temp.next.next;
            curr=curr.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }
}