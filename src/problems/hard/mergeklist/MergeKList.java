package problems.hard.mergeklist;



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

/**
 * Things laernt
 *
 * Lesson 1:
 * Node list has to be incremented to rear always so that addition can happen right or else elements can get replaced
 * For example : Show extreme caution on linese like mergeList = mergeList.next; if we don't do that we can end getting
 * replaced
 *
 * Lesson 2:
 *
 * It is better do all sanity checks further above in the code before they can clutter your code
 * For example : line 57 through 62
 *
 */
public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }


        ListNode sortedList = lists[0];
        for(int i=1; i<lists.length; i++){
            ListNode r = lists[i];
            if(r  == null){
                continue;
            }

            sortedList = merge(sortedList, r);
        }
        return sortedList;
    }


    public ListNode merge(ListNode l, ListNode r ){

        //if one of the list is empty
        if(l== null && r!=null){
            return r;
        }else if(l!=null && r == null){
            return l;
        }


        ListNode mergeList = null;
        ListNode mergeListHeader = null;
        ListNode leftPrev = l;
        ListNode rightPrev = r;


        //if both are not empty
        while(l!=null && r!=null){

            if(l.val <= r.val){
                ListNode node = new ListNode(l.val);
                if(mergeList == null){
                    mergeList = node;
                    mergeListHeader = node;
                }else{
                    mergeList.next = node;
                    mergeList = mergeList.next;
                }


                leftPrev = l;
                l = l.next;


            }else{
                //start merge
                ListNode node = new ListNode(r.val);
                if(mergeList == null){
                    mergeList = node;
                    mergeListHeader = node;
                }else{
                    mergeList.next = node;
                    mergeList = mergeList.next;
                }

                rightPrev = r;
                r = r.next;

            }
        }

        //collect left over
        if(r!=null){

            mergeList.next = r;

        }else if(l!=null){

            mergeList.next = l;
        }

        return mergeListHeader;
    }

    private void addNode(ListNode mergeList, ListNode mergeListHeader, int val){
        ListNode node = new ListNode(val);

        if(mergeList == null){
            mergeList = node;
            mergeListHeader = node;
        }else{
            mergeList.next = node;
            mergeList = mergeList.next;
        }
    }
}