package linkedlist.easy;

public class MergeTwoLists {

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

        private ListNode head;
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if(list1 == null && list2 == null){
                return null;
            }

            if(list1 == null){
                return list2;
            }else if(list2 == null){
                return list1;
            }

            ListNode head = null;
            while(list1!=null && list2!=null){
                if(list1.val < list2.val){
                    ListNode node = new ListNode(list1.val);

                    if(head == null){
                        head = node;
                        this.head = head;
                    }else{
                        head.next = node;
                        head = head.next;
                    }
                    list1 = list1.next;

                }else{
                    ListNode node = new ListNode(list2.val);

                    if(head == null){
                        head = node;
                        this.head = head;
                    }else{
                        head.next = node;
                        head = head.next;
                    }
                    list2 = list2.next;
                }
            }

            if(list1 == null){
                head.next = list2;
            }else if(list2 == null){
                head.next = list1;
            }

            return this.head;
        }
    }
}
