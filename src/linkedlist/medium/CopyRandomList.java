package linkedlist.medium;


import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    private Node newHead;
    private Node oldHead;

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Node, Node> oldToCopy = new HashMap<Node, Node>();
        oldHead= head;
        Node prev = null;

        //first pass to clone
        while (head!=null){
            Node n = new Node(head.val);
            if(prev!=null){
                prev.next = n;
            }else{
                newHead = n;
            }

            //randomNodeMap.put(n.val, n.random);
            oldToCopy.put(head, n);
            prev = n;
            head = head.next;
        }

        head = oldHead;

        while(head!=null){

            var curNode = oldToCopy.get(head);
            if(head.random != null){
                var randomNode = oldToCopy.get(head.random);
                curNode.random = randomNode;
            }
            //I forgot this
            head = head.next;
        }

        return newHead;
    }
}
