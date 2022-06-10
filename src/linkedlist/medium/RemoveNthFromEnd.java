package linkedlist.medium;

public class RemoveNthFromEnd {

    private ListNode headPointer;
    private int length;

    /**
     * Remember the edge case when the length = 1
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return null;
        }


        this.headPointer = head;
        this.length = n;


        removeNthFromEnd(head, head.next);

        this.length--;


        if(this.length == 0){
            //handle node length 1 and n=1
            this.headPointer = head.next;

        }

        return this.headPointer;

    }

    private void removeNthFromEnd(ListNode parent, ListNode current){

        if(current==null){

            return;
        }

        removeNthFromEnd(current, current.next);

        this.length--;

        if(this.length == 0){
            parent.next = current.next;
            //sanity
            current = null;
        }





    }
}
