package linkedlist.easy;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ReverseLinkedList {

    private ListNode head;

    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }
        this.head = head;

        if(head.next!=null){
            reverseListRecur(head, head.next);
            return this.head;
        }else{
            return head;
        }
    }


    private ListNode reverseListRecur(ListNode parent, ListNode current){

        if(current.next == null){
            current.next = parent;
            parent.next = null;
            //this is the key setting the head to
            this.head = current;
            return parent;
        }

        current = reverseListRecur(current, current.next);
        current.next = parent;
        parent.next = null;
        return parent;
    }
}
