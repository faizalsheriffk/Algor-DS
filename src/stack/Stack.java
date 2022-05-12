package stack;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> list = new ArrayList<T>();

    public void push(T t){
        list.add(t);
    }

    public T pop(){ //TODO throws exception on removing in an empty list
        return list.remove(list.size()-1);
    }

    public T peek(){
        return list.get(list.size() -1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }
}
