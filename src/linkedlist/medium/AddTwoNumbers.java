package linkedlist.medium;





public class AddTwoNumbers {

    private ListNode resHeader = new ListNode(0);
    private ListNode res = resHeader;


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1== null || l2 == null){
            return null; // new IllegalStateException
        }


        addTwoNum(l1, l2, 0);
        return resHeader.next;
    }

    // 2 4 9 7
    // 8 1 6 7
    private void addTwoNum(ListNode l1, ListNode l2, int rem){


        if(l1 == null && l2 == null){
            // resHeader = res;
            if(rem >0){
                res.next = new ListNode(rem);

                res = res.next;
            }
            return;
        }


        int l1val = l1!=null?l1.val:0;
        int l2val = l2!=null?l2.val:0;

        int val = l1val+l2val+rem;


        res.next = new ListNode(val%10);

        res = res.next;
        addTwoNum(l1!=null?l1.next:l1, l2!=null?l2.next:l2, val/10) ;

    }
}






