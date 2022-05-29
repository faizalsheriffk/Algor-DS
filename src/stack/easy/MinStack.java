package stack.easy;



import java.util.Iterator;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;

    public MinStack() {

        this.stack = new Stack<Integer>();

    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;

        Iterator ite = stack.iterator();
        while(ite.hasNext()){
            int n = (int)ite.next();
            if(min>n){
                min = n;
            }
        }
        return min;
    }
}
