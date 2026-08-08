/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head,nextNode=null,prevNode=null;
        while(temp!=null){
            ListNode KthNode=findKthNode(temp,k);
            if(KthNode==null){
                if(prevNode!=null) prevNode.next=temp;
                break;
            }
            nextNode=KthNode.next;
            KthNode.next=null;
            reverseList(temp);
            if(temp==head) head=KthNode;
            else prevNode.next=KthNode;
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }

    public ListNode findKthNode(ListNode head, int k) {
        ListNode temp=head;
        int count=1;
        while(temp!=null){
            count++;
            temp=temp.next;
            if(count==k) return temp;
        }
        return null;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null) next=next.next;
        }
        return prev;
    }
}