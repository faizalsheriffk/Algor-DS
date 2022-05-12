package queue;

import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> list = new ArrayList<T>();

    public void enqueue(T t){
        this.list.add(t);
    }

    public T dequeue(){
        if(list.isEmpty())
            throw new IllegalStateException("Queue is empty");
        return list.remove(0);
    }

    public T poll(T t){
        return list.get(0);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
