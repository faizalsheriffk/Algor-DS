package linkedlist.medium;



  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/**
 * we learnt two pointer technique to find the center of the linked list
 *
 */

public class ReOrderList {

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;

        /**
         * moving the pointer
         */
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * Three pointer reverse solution
         */

        ListNode prev = null, next = null;
        ListNode current = slow;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }


        /**
         * Merge two list
         */
        ListNode reverseHead = prev;
        ListNode firstHead = head;

        while(reverseHead.next!=null){
            var temp = firstHead.next;
            var temp1 = reverseHead.next;

            firstHead.next = reverseHead;
            reverseHead.next = temp;


            reverseHead = temp1;
            firstHead = temp;

        }


    }
}
