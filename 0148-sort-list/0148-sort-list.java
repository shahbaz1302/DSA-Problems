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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle=findMiddle(head);
        ListNode left=head;
        ListNode right=middle.next;
        middle.next=null;
        left=sortList(left);
        right=sortList(right);
        return mergeLists(left,right);
    }

    public ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        ListNode t1=head1, t2=head2;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                curr.next = t1;
                curr = t1;
                t1 = t1.next;
            }
            else{
                curr.next = t2;
                curr = t2;
                t2 = t2.next;
            }
        }
        curr.next = t1 == null ? t2 : t1;
        return dummyHead.next;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}