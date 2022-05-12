package queue;

import stack.Stack;

public class MainTester {


    public static void main(String[] args){

        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3); q.enqueue(4);



        reverseQueue(q);



        CircularQueueClean<Integer> cQ = new CircularQueueClean<Integer>(Integer.class, 5);
        cQ.enQueue(1);
        cQ.enQueue(2);
        cQ.enQueue(3);
        cQ.enQueue(4);
        cQ.enQueue(5);

        cQ.dequeue();
        cQ.enQueue(6);

        cQ.dequeue();
        cQ.dequeue();

        cQ.enQueue(7);
        cQ.enQueue(8);


        PriorityQueue pQ = new PriorityQueue(5);

        pQ.enQueue(1);
        pQ.enQueue(3);
        pQ.enQueue(2);
        pQ.enQueue(7);
        pQ.enQueue(4);


    }

    private static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<Integer>();

        while(!q.isEmpty()){
            stack.push(q.dequeue());
        }

        while(!stack.isEmpty()){
            q.enqueue(stack.pop());
        }

        while(!q.isEmpty())
            System.out.println(q.dequeue());
    }
}
