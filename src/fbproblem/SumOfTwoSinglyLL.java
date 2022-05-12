package fbproblem;

public class SumOfTwoSinglyLL {


    private ListNode resHeader = new ListNode(0);
    private ListNode res = resHeader;


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null; // new IllegalStateException
        }


        addTwoNum(l1, l2, 0);
        return resHeader.next;
    }

    // 2 4 9 7
    // 8 1 6 7
    private void addTwoNum(ListNode l1, ListNode l2, int rem) {


        if (l1 == null && l2 == null) {

            if (rem > 0) {
                res.next = new ListNode(rem);

                res = res.next;
            }
            return;
        }


        int l1val = l1 != null ? l1.val : 0;
        int l2val = l2 != null ? l2.val : 0;

        int val = l1val + l2val + rem;
        res.next = new ListNode(val % 10);
        res = res.next;

        addTwoNum(l1 != null ? l1.next : l1, l2 != null ? l2.next : l2, val / 10);

    }

    public static void main(String args[]) {

        ListNode l1 = new ListNode(2);
        ListNode l1Next = new ListNode(4);
        l1.next = l1Next;
        ListNode l1Next2 = new ListNode(3);
        l1.next.next = l1Next2;

        ListNode l2 = new ListNode(5);
        ListNode l2Next = new ListNode(6);
        l2.next = l2Next;
        ListNode l2Next2 = new ListNode(4);
        l2.next.next = l2Next2;

        new SumOfTwoSinglyLL().addTwoNumbers(l1, l2);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

