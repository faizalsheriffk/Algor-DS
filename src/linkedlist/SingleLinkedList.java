package linkedlist;

public class SingleLinkedList<T> {

    public static void main(String[] args) {

        SingleLinkedList<Integer> sl = new SingleLinkedList<Integer>();
        sl.test();

    }


    private Node<T> head = null;
    private Node<T> tail = null;

    public void test(){
        //SingleLinkedList<Integer> sl = new SingleLinkedList<Integer>();
        Node n = new Node(10);
        addNode(n);
        n = new Node(20);
        addNode(n);
        n = new Node(30);
        addNode(n);
//        n = new Node(40);
//        addNode(n);
        display();
        System.out.println("");


        Node kthNode = getKthNode(3);

        if(kthNode!=null)
            System.out.println("print kth node"+ kthNode.value);
        else
            System.out.println("list is too small may be");


        reverse(head);
        display();
        System.out.println("");

        reverseNonRecursive(head);
        display();
        System.out.println("");


        removeFirst();
        System.out.println("");
        display();

        removeLast();
        System.out.println("");
        display();

        removeFirst();
        System.out.println("");
        display();

        removeLast();
        System.out.println("");
        display();
    }


    public void reverse(Node<T> node){
        Node<T> prevNode = node;
        Node<T> currentNode = null;
        if (node.next != null){
            currentNode = node.next;
            reverse (currentNode);
            currentNode.next = prevNode;
            prevNode.next = null;
        }else{
            head = node;
        }
        tail = prevNode;
    }

    public void reverseNonRecursive(Node<T> node){
        Node<T> prevNode = null;
        Node<T> currentNode = null;
        Node<T> nextNode = null;
        head = node;

        //base cases
        if(node == null || node.next == null){
            tail = node;
            return;
        }else if(node.next.next == null){
            node.next.next = node;
            head = node;
            tail = node.next;
            return;
        }else{
            tail = node;
            prevNode = node;
            currentNode = node.next;
            nextNode = node.next.next;
            while(nextNode !=null){
                prevNode.next = null;
                currentNode.next = prevNode;

                //moving the pointers
                prevNode = currentNode;
                currentNode = nextNode;
                nextNode = nextNode.next;
                //always run your code with the sample
            }
            currentNode.next = prevNode;
            head = currentNode;
        }
    }

    public void addNode(Node<T> node) {
        if (head == null) {
            head = node;

        } else {
            tail.next = node;

        }
        tail = node;
    }

    public void removeFirst(){

        if(head!=null){
            head = head.next;
        }
    }


    public void removeLast(){
        Node<T> ptr = head;

        if(head == null){
            System.out.println("List is empty");
            return ;
        }
        else if(head!=null && head == tail){
            //one node list
            head = null;
            tail = null;
            System.out.println("List is emptied");
        }else {

            while (ptr.next != null && ptr.next.next != null) {
                ptr = ptr.next;
                continue;
            }

            tail = ptr;
            tail.next = null;
        }
    }


    public Node<T> getKthNode(int k) {
        Node one = head;
        Node two = one;
        boolean isListTooSmall = false;
        int distance = 0;

        if(k<=1){
            return head;
        }
        //3_4_5_6_9
        //  *     *
        //half pass
        distance = k-1;
        for (int i = 0; i <= distance; i++) {
            if(two.next!=null){
                two = two.next;
                continue;
            }
            if(i<k) {
                isListTooSmall = true;
                break;
            }
        }

        if(isListTooSmall){
            return null;
            //throw an execption
        }

        while(two.next!=null){
            one = one.next;
            two = two.next;
        }

        return one;

    }


    public void display(){

        Node<T> ptr = head;
        while(ptr != null){
            System.out.println(ptr.value);
            ptr = ptr.next;
        }
    }

    public void remove(Node<T> node){

    }


    private class Node<T> {
        T value;
        Node next = null;

        Node() {

        }

        Node(T t) {
            this.value = t;
        }

    }
}

