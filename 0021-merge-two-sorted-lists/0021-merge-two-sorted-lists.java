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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        ListNode t1=list1, t2=list2;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                curr.next = t1;
                curr = curr.next;
                t1 = t1.next;
            }
            else{
                curr.next = t2;
                curr = curr.next;
                t2 = t2.next;
            }
        }
        curr.next = t1 == null ? t2 : t1;
        return dummyHead.next;
    }
}