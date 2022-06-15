package linkedlist.easy;

public class FindCycle {
    /**
     * Using floyd cycle finding algorith which is nothing but
     * two pointer algorithm, slow and fast.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        //following two pointer approach

        if(head == null){
            return;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=slow){

            if(fast == null || fast.next == null){
                return false;
            }


            slow = head.next;
            fast = head.next.next;
        }
        return true;
    }
}
